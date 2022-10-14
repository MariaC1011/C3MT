/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Boat;
import com.example.demo.Servicio.BoatService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/Boat")

public class BoatController {
    @Autowired
    private BoatService boatService;
    
    @GetMapping("/all")
    public List<Boat> getAll(){
        return boatService.getAll();
    }
    
    
    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int id){
        return boatService.getBoat(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save (@RequestBody Boat boat){
        return boatService.save(boat);
        
    }
     
}
