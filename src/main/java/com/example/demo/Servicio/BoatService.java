/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Boat;
import com.example.demo.Repositorio.BoatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class BoatService {
     @Autowired
    private BoatRepository boatRepository;
    
    public List<Boat> getAll(){
        return boatRepository.getAll();
    }
    
    
    public Optional<Boat> getBoat(int id){
        return boatRepository.getBoat(id);
    }
    
    public Boat save (Boat boat){
        if (boat.getId()== null){
            return boatRepository.save(boat);
        }else {
            Optional<Boat> boat1 = boatRepository.getBoat(boat.getId());
            if (boat1.isEmpty()){
                return boatRepository.save(boat);
            }else{
                return boat;
            }
        }
    }
}
    
