package com.uniroma3.esamesiw2024.entity;

import jakarta.persistence.*;

@Entity
public class Credentials {

    public static final String DEFAULT_ROLE = "DEFAULT";
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String PRESIDENTE_ROLE = "PRESIDENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment_id")
    @SequenceGenerator(name="increment_id", sequenceName = "INCREMENT_ID", allocationSize = 1)
    private Long id;
    private String username;
    private String password;
    private String role;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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