package ru.optima.controller.repr;

import ru.optima.persist.model.Work;
import ru.optima.persist.model.Role;
import ru.optima.persist.model.User;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRepr {

    private Long id;

    @NotEmpty
    private String password;

    private String firstName;

    @NotEmpty
    private String lastName;

    private String phone;

    private String email;

    private Collection<Role> roles;

    private List<Work> works;



    public UserRepr() {
    }

    public UserRepr(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phone = user.getPhone();
        this.roles = user.getRoles();
        this.works = user.getWorks();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "UserRepr{" +
                "id=" + id +
                ", username='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
