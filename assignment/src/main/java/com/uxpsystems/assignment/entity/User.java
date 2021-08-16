package com.uxpsystems.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = {"id","userName"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true,nullable = false)
    private String userName;
    private String password;
    private String status;

    public User(){

    }

    public User(Long id, String userName, String password, String status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
