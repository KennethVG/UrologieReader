package be.somedi.urologiereader.service.impl;

import be.somedi.urologiereader.entity.Person;
import be.somedi.urologiereader.repository.PersonRepository;
import be.somedi.urologiereader.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person findByInss(String inss) {
        return repository.findByInss(inss);
    }
}
