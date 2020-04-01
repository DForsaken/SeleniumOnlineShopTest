package com.hellofresh.challenge.data;

public class User {
    private String email;
    private String name;
    private String surname;
    private String password;

    public User(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public User() {
        this.email = "hf_challenge_123456@hf123456.com";
        this.name = "Joe";
        this.surname = "Black";
        this.password = "12345678";
    }

    public User(String email) {
        this.email = email;
        this.name = "Joe";
        this.surname = "Black";
        this.password = "12345678";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return name + " " + surname;
    }
}
