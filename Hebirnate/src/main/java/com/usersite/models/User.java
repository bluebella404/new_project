package com.usersite.models;

/**
 * Created by Михаил on 2017-04-29.
 */

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable {


    private static final long serialVersionUID = -6136701049967080191L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, updatable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    public User(String username, String password, String role) {
        this.setId(-1);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
