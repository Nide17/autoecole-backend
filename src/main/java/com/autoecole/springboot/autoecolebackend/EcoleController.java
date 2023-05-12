package com.autoecole.springboot.autoecolebackend;

import java.io.IOException;
import java.util.List;
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
@RequestMapping("api/v1/ecoles") // THIS IS THE ROOT URL
public class EcoleController {

    // INJECT EcoleRepository
    private final EcoleRepository ecoleRepository;

    // CONSTRUCTOR INJECTION - INJECT EcoleRepository
    public EcoleController(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    // MAPPING THE URL TO THE METHOD - GET ALL ECOLES
    @GetMapping // CHILD URL
    public List<Ecole> getAllEcoles() {

        // GET ALL ECOLES FROM DATABASE
        return ecoleRepository.findAll();
    }

    // POST - CREATE A NEW ECOLE
    @PostMapping("/create")
    public void createEcole(@RequestBody NewEcoleRequest request) throws IOException {
        // CREATE A NEW ECOLE
        Ecole ecole = new Ecole();
        ecole.setName(request.name);
        ecole.setPhone(request.phone);
        ecole.setEmail(request.email);
        ecole.setLocation(request.location);
        ecole.setCategories(request.categories);

        // SAVE THE NEW ECOLE TO DATABASE
        ecoleRepository.save(ecole);
    }

    // CREATE A NEW ECOLE REQUEST CLASS TO HOLD THE REQUEST DATA
    record NewEcoleRequest(String name, String phone, String email, String location, String categories) {
    }

    // DELETE - DELETE AN ECOLE
    @DeleteMapping("/delete/{ecoleId}")
    public void deleteEcole(@PathVariable("ecoleId") Long id) {
        ecoleRepository.deleteById(id);
    }

    // PUT - UPDATE AN ECOLE
    @PutMapping("/update/{ecoleId}")
    public void updateEcole(
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
    }
}
