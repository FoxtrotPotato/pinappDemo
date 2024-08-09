package com.fp.pinappDemo.rest.restService;

import com.fp.pinappDemo.entity.AgeStatistics;
import com.fp.pinappDemo.entity.Client;

import java.util.List;

public interface ClientRestService {

    List<Client> findAll();

    AgeStatistics getAgeStatistics();

    Client createClient(Client client);

}
