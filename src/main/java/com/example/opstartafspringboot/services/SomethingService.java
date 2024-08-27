package com.example.opstartafspringboot.services;

import com.example.opstartafspringboot.models.Person;
import com.example.opstartafspringboot.repositories.SomethingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SomethingService {

    private SomethingRepository somethingRepository;

    public SomethingService(SomethingRepository somethingRepository) {
        this.somethingRepository = somethingRepository;
    }

    public void addUser(String name, int age) {
        somethingRepository.addUser(name, age);
    }

    public List<Person> getAllUsers() {
        return somethingRepository.getAllUsers();
    }

    public void removeUser(int personId) {
        somethingRepository.removeUser(personId);
    }
}
