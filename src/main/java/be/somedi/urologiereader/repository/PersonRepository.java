package be.somedi.urologiereader.repository;

import be.somedi.urologiereader.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByInss(String inss);

}
