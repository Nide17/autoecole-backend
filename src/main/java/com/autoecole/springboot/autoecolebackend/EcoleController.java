package com.autoecole.springboot.autoecolebackend;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoleController {
    // http://localhost:8080/ecoles
    // Return all ecoles

    // MAPPING THE URL TO THE METHOD
    @RequestMapping("/ecoles")
    public List<Ecole> getAllEcoles() {
        return Arrays.asList(
            new Ecole(1, "Sinai", "0785157542", "sinairwanda@gmail.com", "Kigali", "P, A, B, C, D, E"),
            new Ecole(2, "New Vision", "0788552244", "newvision@gmail.com", "Musanze", "P, A, B, D, F")
        );
    }
    
}
