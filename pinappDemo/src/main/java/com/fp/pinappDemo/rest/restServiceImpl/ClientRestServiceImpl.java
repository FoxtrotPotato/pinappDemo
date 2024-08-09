package com.fp.pinappDemo.rest.restServiceImpl;

import com.fp.pinappDemo.entity.AgeStatistics;
import com.fp.pinappDemo.entity.Client;
import com.fp.pinappDemo.repository.ClientRepository;
import com.fp.pinappDemo.rest.restService.ClientRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRestServiceImpl implements ClientRestService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientRestServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAllByOrderByLastNameAsc();
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


}
