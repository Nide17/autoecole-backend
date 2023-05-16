package com.autoecole.springboot.autoecolebackend.ecoles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity // THIS TELLS COMPILER THAT THIS IS AN ENTITY CLASS TO BE MAPPED TO A TABLE IN DATABASE
public class Ecole {

    // PRIVATE INSTANCE VARIABLES
    @Id // THIS TELLS COMPILER THAT THIS IS THE PRIMARY KEY
    @SequenceGenerator(
            // SEQUENCE IS A WAY TO GENERATE UNIQUE VALUES FOR A PRIMARY KEY
            name = "ecole_sequence", sequenceName = "ecole_sequence", allocationSize = 1)

    // GENERATION TYPE IS SEQUENCE, IT IS A WAY TO GENERATE UNIQUE VALUES FOR A PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecole_sequence")
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
