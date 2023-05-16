package com.autoecole.springboot.autoecolebackend.ecoles;
import org.springframework.data.jpa.repository.JpaRepository;

// THIS INTERFACE EXTENDS JPA REPOSITORY
// JPA REPOSITORY IS A COLLECTION OF METHODS TO ACCESS DATA FROM DATABASE
// THE FIRST ARGUMENT IS THE ENTITY CLASS
// THE SECOND ARGUMENT IS THE TYPE OF THE PRIMARY KEY
// THIS INTERFACE IS USED BY THE CONTROLLER CLASS
// IT HAS ALL THE SUPER POWERS TO PERFORM CRUD OPERATIONS
public interface EcoleRepository extends JpaRepository<Ecole, Long>{} // IMPLEMENTED BY THE CONTROLLER CLASS AND USED TO PERFORM CRUD OPERATIONS

/*
 * JpaRepository is an interface provided by the Spring Data JPA framework,
 * which is a part of the larger Spring Data project. It provides a set of
 * methods and functionality to interact with a relational database using Java
 * Persistence API (JPA) entities.
 */