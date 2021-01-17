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

    @Column(name = "factoryNumber")
    private Long factoryNumber;

    @Column(name = "verificationNumber")
    private Long verificationNumber;

    @Column(name = "verificationDate")
    private LocalDate verificationDate;

    @Column(name = "verificationDateEnd")
    private LocalDate verificationDateEnd;

    @ManyToMany(mappedBy = "equipments")
    private List<User> users;

    public Equipment() {
    }

    public Equipment(Long id, String name, Integer inventoruNumber, Long factoryNumber, Long verificationNumber, LocalDate verificationDate, LocalDate verificationDateEnd, List<User> users, List<Work> work) {
        this.id = id;
        this.name = name;
        this.inventoruNumber = inventoruNumber;
        this.factoryNumber = factoryNumber;
        this.verificationNumber = verificationNumber;
        this.verificationDate = verificationDate;
        this.verificationDateEnd = verificationDateEnd;
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

    public void setInventoruNumber(Integer inventoruNumber) {
        this.inventoruNumber = inventoruNumber;
    }

    public Long getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(Long factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public Long getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(Long verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public LocalDate getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate = verificationDate;
    }

    public LocalDate getVerificationDateEnd() {
        return verificationDateEnd;
    }

    public void setVerificationDateEnd(LocalDate verificationDateEnd) {
        this.verificationDateEnd = verificationDateEnd;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
