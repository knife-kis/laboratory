package ru.optima.persist.model;

import org.springframework.beans.propertyeditors.CustomDateEditor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
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

    @Column(name = "inventoru_number", nullable = false)
    private String inventoruNumber;

    @Column(name = "factory_number")
    private String factoryNumber;

    @Column(name = "verification_number")
    private String verificationNumber;

    @Column(name = "verification_date")
    private Date verificationDate;

    @Column(name = "verification_date_End")
    private Date verificationDateEnd;

    @ManyToMany(mappedBy = "equipments")
    private List<User> users;

    public Equipment() {
    }

    public Equipment(Long id, String name, String inventoruNumber, String factoryNumber, String verificationNumber, Date verificationDate, Date verificationDateEnd, List<User> users) {
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

    public String getInventoruNumber() {
        return inventoruNumber;
    }

    public void setInventoruNumber(String inventoruNumber) {
        this.inventoruNumber = inventoruNumber;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public String getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(String verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public Date getVerificationDateEnd() {
        return verificationDateEnd;
    }

    public void setVerificationDateEnd(Date verificationDateEnd) {
        this.verificationDateEnd = verificationDateEnd;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
