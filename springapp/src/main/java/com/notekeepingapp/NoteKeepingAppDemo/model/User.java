package com.notekeepingapp.NoteKeepingAppDemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "userId", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    @Column(name = "UserName")
    @NotBlank(message = "Enter a user name ")
    private String username;

    @Column(name = "Password")
    @NotBlank(message = "Enter a Password ")
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
