package ru.optima.persist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "RegistrationDate", nullable = false)
    private Date registrationDate;

    @Column(name = "clientName", nullable = false)
    private String clientName;

    @Column(name = "objectName")
    private String objectName;

    @Column(name = "numberContract", nullable = false, unique = true)
    private String numberContract;

    @ManyToMany(mappedBy = "equipment")
    private List<User> users;

    @Column(name = "customer")
    private String customer;

    public Equipment() {
    }

    public Equipment(int id, Date registrationDate, String clientName, String objectName, String numberContract, List<User> users, String customer) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.clientName = clientName;
        this.objectName = objectName;
        this.numberContract = numberContract;
        this.users = users;
        this.customer = customer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id) &&
                Objects.equals(registrationDate, equipment.registrationDate) &&
                Objects.equals(clientName, equipment.clientName) &&
                Objects.equals(objectName, equipment.objectName) &&
                Objects.equals(numberContract, equipment.numberContract) &&
                Objects.equals(users, equipment.users) &&
                Objects.equals(customer, equipment.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationDate, clientName, objectName, numberContract, users, customer);
    }
}
