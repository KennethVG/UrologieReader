package be.somedi.urologiereader.service;

import be.somedi.urologiereader.entity.Person;

public interface PersonService {

    Person findByInss(String inss);

}
