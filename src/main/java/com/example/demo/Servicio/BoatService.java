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
    
    public Boat update (Boat boat){
        if (boat.getId() !=null){
             Optional<Boat> e= boatRepository.getBoat(boat.getId());
            if(!e.isEmpty()){
            
                if(boat.getName()!=null){
                    e.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                 e.get().setBrand(boat.getBrand());
            }
                if(boat.getYear()!=null){
                 e.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                 e.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                 e.get().setCategory(boat.getCategory());
                }
                boatRepository.save(e.get());
                return e.get();
            }else{
                return boat;
            }
        }else{
        return boat;
        }
    }
    public boolean deleteBoat(int id){
        Boolean d = getBoat(id).map(boat -> {
            boatRepository.delete(boat);
            return true;
        }).orElse(false);
        return d;
    }
}
    
