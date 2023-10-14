package com.autoecole.springboot.autoecolebackend.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity // THIS TELLS COMPILER THAT THIS IS AN ENTITY CLASS TO BE MAPPED TO A TABLE IN
        // DATABASE
public class Contact {

    // PRIVATE INSTANCE VARIABLES
    @Id // THIS TELLS COMPILER THAT THIS IS THE PRIMARY KEY
    @SequenceGenerator(
            // SEQUENCE IS A WAY TO GENERATE UNIQUE VALUES FOR A PRIMARY KEY
            name = "contact_sequence", sequenceName = "contact_sequence", allocationSize = 1)

    // GENERATION TYPE IS SEQUENCE, IT IS A WAY TO GENERATE UNIQUE VALUES FOR A
    // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_sequence")
    private long id;
    private String name;
    private String email;
    private String message;

    // CONSTUCTOR METHODS
    public Contact() {
    }

    public Contact(long i, String nom, String mail, String message) {
        // ASSIGN INSTANCE VARIABLES FROM LOCAL VARIABLES
        this.id = i;
        this.name = nom;
        this.email = mail;
        this.message = message;
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

    public void setName(String nom) {
        this.name = nom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // TO STRING METHOD
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", message='" + getMessage() + "'" +
                "}";
    }
}
