package be.somedi.urologiereader.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dbo.PersonalInfo_Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    private String inss;

    @Transient
    private String UrlToPDF;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getInss() {
        return inss;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }

    public String getUrlToPDF() {
        return UrlToPDF;
    }

    public void setUrlToPDF(String urlToPDF) {
        UrlToPDF = urlToPDF;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", inss='" + inss + '\'' +
                ", UrlToPDF='" + UrlToPDF + '\'' +
                '}';
    }
}