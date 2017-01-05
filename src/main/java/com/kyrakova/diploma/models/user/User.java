package com.kyrakova.diploma.models.user;

import com.kyrakova.diploma.models.BaseModel;
import com.kyrakova.diploma.models.role.Role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Users")
public class User extends BaseModel implements Serializable {
    private Role role;
    private String login;
    private String password;
    private String email;
    private String fio;
    private String address;

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
