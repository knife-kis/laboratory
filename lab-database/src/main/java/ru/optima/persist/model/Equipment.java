package ru.optima.persist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "equipments")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inventoruNumber", nullable = false)
    private Integer inventoruNumber;

    @Column(name = "inventoruNumber")
    private Long factoryNumber;

    @Column(name = "verificationNumber")
    private Long verificationNumber;

    @Column(name = "verificationDate", nullable = false)
    private LocalDate verificationDate;

    @ManyToMany(mappedBy = "works")
    private List<User> users;

    public Equipment() {
    }

    public Equipment(Long id, String name, Integer inventoruNumber, Long factoryNumber, Long verificationNumber, LocalDate verificationDate, List<User> users) {
        this.id = id;
        this.name = name;
        this.inventoruNumber = inventoruNumber;
        this.factoryNumber = factoryNumber;
        this.verificationNumber = verificationNumber;
        this.verificationDate = verificationDate;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInventoruNumber() {
        return inventoruNumber;
    }

    public void setInventoruNumber(int inventoruNumber) {
        this.inventoruNumber = inventoruNumber;
    }

    public Long getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(long factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public Long getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(long verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public LocalDate getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate = verificationDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return inventoruNumber == equipment.inventoruNumber &&
                factoryNumber == equipment.factoryNumber &&
                verificationNumber == equipment.verificationNumber &&
                Objects.equals(id, equipment.id) &&
                Objects.equals(name, equipment.name) &&
                Objects.equals(verificationDate, equipment.verificationDate) &&
                Objects.equals(users, equipment.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, inventoruNumber, factoryNumber, verificationNumber, verificationDate, users);
    }
}
