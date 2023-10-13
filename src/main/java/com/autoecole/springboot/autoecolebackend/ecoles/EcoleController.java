package com.autoecole.springboot.autoecolebackend.ecoles;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // THIS TELLS COMPILER THAT THIS IS A REST CONTROLLER THAT PERFORMS CRUD
                // OPERATIONS
@RequestMapping("/api/v1") // THIS IS THE ROOT URL
@CrossOrigin(origins = "*") // THIS IS TO ALLOW CROSS ORIGIN REQUESTS
public class EcoleController {

    // INJECT EcoleRepository WHICH GIVES US ACCESS TO CRUD OPERATIONS
    private final EcoleRepository ecoleRepository;

    // CONSTRUCTOR INJECTION - INJECT EcoleRepository
    public EcoleController(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }
    
    // MAPPING THE URL TO THE METHOD - GET ALL ECOLES
    @GetMapping
    public List<Ecole> getAllEcoles() {

        // GET ALL ECOLES FROM DATABASE
        return ecoleRepository.findAll();
    }

    // MAPPING THE URL TO THE METHOD - GET AN ECOLE BY ID
    @GetMapping(path = "/{ecoleId}") // CHILD URL
    public Ecole getEcoleById(@PathVariable("ecoleId") Long id) {

        // CHECK IF THE ECOLE EXISTS
        if (!ecoleRepository.existsById(id)) {
            // PRINT ERROR MESSAGE AND RETURN NULL
            System.out.println("That ecole not found!");
            return null;
        }

        // ELSE RETURN THE ECOLE
        return ecoleRepository.findById(id).get();
    }

    // POST - CREATE A NEW ECOLE
    @PostMapping("")
    public Ecole createEcole(@RequestBody NewEcoleRequest request) throws IOException {
        // CREATE A NEW ECOLE
        Ecole ecole = new Ecole();
        ecole.setName(request.name);
        ecole.setPhone(request.phone);
        ecole.setEmail(request.email);
        ecole.setLocation(request.location);
        ecole.setCategories(request.categories);

        // SAVE THE NEW ECOLE TO DATABASE
        ecoleRepository.save(ecole);

        // RETURN THE NEW ECOLE
        return ecole;
    }

    // CREATE A NEW ECOLE REQUEST CLASS TO HOLD THE REQUEST DATA
    record NewEcoleRequest(String name, String phone, String email, String location, String categories) {
    }

    // DELETE - DELETE AN ECOLE
    @DeleteMapping("/{ecoleId}")
    public Ecole deleteEcole(@PathVariable("ecoleId") Long id) {
        ecoleRepository.deleteById(id);

        // RETURN THE DELETED ECOLE
        return ecoleRepository.findById(id).get();
    }

    // PUT - UPDATE AN ECOLE
    @PutMapping("/{ecoleId}")
    public Ecole updateEcole(
            @PathVariable("ecoleId") Long id,
            @RequestBody NewEcoleRequest request) {
        // GET THE ECOLE FROM DATABASE
        Ecole ecole = ecoleRepository.findById(id).get();

        // UPDATE THE ECOLE
        ecole.setName(request.name);
        ecole.setPhone(request.phone);
        ecole.setEmail(request.email);
        ecole.setLocation(request.location);
        ecole.setCategories(request.categories);

        // SAVE THE UPDATED ECOLE TO DATABASE
        ecoleRepository.save(ecole);

        // RETURN THE UPDATED ECOLE
        return ecole;
    }
}
