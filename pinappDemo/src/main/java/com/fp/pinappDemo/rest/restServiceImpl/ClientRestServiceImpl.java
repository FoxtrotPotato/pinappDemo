package com.fp.pinappDemo.rest.restServiceImpl;

import com.fp.pinappDemo.dto.ClientDTO;
import com.fp.pinappDemo.entity.AgeStatistics;
import com.fp.pinappDemo.entity.Client;
import com.fp.pinappDemo.repository.ClientRepository;
import com.fp.pinappDemo.rest.restService.ClientRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientRestServiceImpl implements ClientRestService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientRestServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client theClient) {
        return clientRepository.save(theClient);
    }

    @Override
    public AgeStatistics getAgeStatistics() {
        List<Integer> listAges = clientRepository.findAllAges();

        double averageAge = listAges.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        double standardDeviation = Math.sqrt(listAges.stream()
                .mapToDouble(age -> Math.pow(age - averageAge, 2))
                .average()
                .orElse(0));

        return new AgeStatistics(averageAge, standardDeviation);
    }

    private Date calculateDeathDate(Date birthday, int age) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        int yearsToAdd = 100 - age;
        calendar.add(Calendar.YEAR, yearsToAdd);

        Date deathDate = calendar.getTime();
        System.out.println("Calculated death date: " + deathDate);

        return deathDate;
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client> clientsList = clientRepository.findAllByOrderByLastNameAsc();
        return clientsList.stream()
                .map(client -> new ClientDTO(
                        client.getClientId(),
                        client.getFirstName(),
                        client.getLastName(),
                        client.getAge(),
                        client.getBirthday(),
                        calculateDeathDate(client.getBirthday(), client.getAge())
                ))
                .collect(Collectors.toList());
    }


}
