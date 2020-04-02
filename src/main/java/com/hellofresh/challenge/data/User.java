package com.hellofresh.challenge.data;

public class User {
    private String email;
    private String name;
    private String surname;
    private String password;

    private String day;
    private String month;
    private String year;

    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postcode;
    private String other;
    private String phone;
    private String mobile;
    private String alias;

    public User(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        setDefaultUserAdditionalInfo();
    }

    public User() {
        this.email = "hf_challenge_123456@hf123456.com";
        this.name = "Joe";
        this.surname = "Black";
        this.password = "12345678";
        setDefaultUserAdditionalInfo();
    }

    public User(String email) {
        this.email = email;
        this.name = "Joe";
        this.surname = "Black";
        this.password = "12345678";
        setDefaultUserAdditionalInfo();
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Fills User with pre set data
     */
    private void setDefaultUserAdditionalInfo() {
        day = "1";
        month = "1";
        year = "2000";
        company = "Company";
        address1 = "Qwerty, 123";
        address2 = "zxcvb";
        city = "Qwerty";
        state = "Colorado";
        postcode = "12345";
        other = "Qwerty";
        phone = "12345123123";
        mobile = "12345123123";
        alias = "hf";
    }
}
