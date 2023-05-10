package com.autoecole.springboot.autoecolebackend;

public class Ecole {

    // PRIVATE INSTANCE VARIABLES
    private long id;
    private String name;
    private String phone;
    private String email;
    private String location;
    private String categories;

    // CONSTUCTOR METHODS
    public Ecole() {
    }

    public Ecole(long i, String nom, String tel, String mail, String address, String licenses) {
        // ASSIGN INSTANCE VARIABLES FROM LOCAL VARIABLES
        this.id = i;
        this.name = nom;
        this.phone = tel;
        this.email = mail;
        this.location = address;
        this.categories = licenses;
    }

    // GETTER & SETTER METHODS
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    // TOSTRING METHOD
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", phone='" + getPhone() + "'" +
                ", email='" + getEmail() + "'" +
                ", location='" + getLocation() + "'" +
                ", categories='" + getCategories() + "'" +
                "}";
    }

}
