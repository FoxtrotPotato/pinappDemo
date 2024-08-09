package com.fp.pinappDemo.rest.restService;

import com.fp.pinappDemo.dto.ClientDTO;
import com.fp.pinappDemo.entity.AgeStatistics;
import com.fp.pinappDemo.entity.Client;

import java.util.List;

public interface ClientRestService {

    List<ClientDTO> findAll();

    AgeStatistics getAgeStatistics();

    Client createClient(Client client);

}
