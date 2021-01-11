package ru.optima.controller.repr;

import ru.optima.persist.model.Equipment;
import ru.optima.persist.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EquipmentRepr implements Serializable {

    private int id;
    private Date registrationDate;
    private String clientName;
    private String objectName;
    private String numberContract;
    private List<User> users;
    private String customer;

    public EquipmentRepr() {
    }

    public EquipmentRepr(Equipment equipment) {
        this.id = equipment.getId();
        this.registrationDate = equipment.getRegistrationDate();
        this.clientName = equipment.getClientName();
        this.objectName = equipment.getObjectName();
        this.numberContract = equipment.getNumberContract();
        this.users = equipment.getUsers();
        this.customer = equipment.getCustomer();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}

