package com.fp.pinappDemo.repository;

import com.fp.pinappDemo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByOrderByLastNameAsc();

    @Query("SELECT c.age FROM Client c")
    List<Integer> findAllAges();



}

