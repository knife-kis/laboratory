package ru.optima.controller.repr;

import ru.optima.persist.model.Equipment;
import ru.optima.persist.model.User;
import ru.optima.persist.model.Work;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EquipmentRepr implements Serializable {

    private Long id;
    private String name;
    private Integer inventoruNumber;
    private Long factoryNumber;
    private Long verificationNumber;
    private LocalDate verificationDate;
    private LocalDate verificationDateEnd;
    private List<User> users;

    public EquipmentRepr() {
    }

    public EquipmentRepr(Equipment equipment) {
        this.id = equipment.getId();
        this.name = equipment.getName();
        this.inventoruNumber = equipment.getInventoruNumber();
        this.factoryNumber = equipment.getFactoryNumber();
        this.verificationNumber = equipment.getVerificationNumber();
        this.verificationDate = equipment.getVerificationDate();
        this.verificationDateEnd = equipment.getVerificationDateEnd();
        this.users = equipment.getUsers();
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

