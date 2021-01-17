package ru.optima.persist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "works")
public class Work implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "RegistrationDate", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "clientName", nullable = false)
    private String clientName;

    @Column(name = "objectName")
    private String objectName;

    @Column(name = "numberContract", nullable = false, unique = true)
    private String numberContract;

    @ManyToMany(mappedBy = "works")
    private List<User> users;

    @Column(name = "customer")
    private String customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "works_equpments",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipment;

    public Work() {
    }

    public Work(Long id, LocalDate registrationDate, String clientName, String objectName, String numberContract, List<User> users, String customer, Set<Equipment> equipment) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.clientName = clientName;
        this.objectName = objectName;
        this.numberContract = numberContract;
        this.users = users;
        this.customer = customer;
        this.equipment = equipment;
    }

    public Set<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
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
        Work work = (Work) o;
        return Objects.equals(id, work.id) &&
                Objects.equals(registrationDate, work.registrationDate) &&
                Objects.equals(clientName, work.clientName) &&
                Objects.equals(objectName, work.objectName) &&
                Objects.equals(numberContract, work.numberContract) &&
                Objects.equals(users, work.users) &&
                Objects.equals(customer, work.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationDate, clientName, objectName, numberContract, users, customer);
    }
}
