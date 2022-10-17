/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.BoatInterface;
import com.example.demo.Modelo.Boat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class BoatRepository {
    @Autowired
    private BoatInterface extensionesCrud;
    
    public List<Boat> getAll(){
        return (List<Boat>)extensionesCrud.findAll();
   }
   
    public Optional<Boat> getBoat(int id){
        return extensionesCrud.findById(id);
    }
    
    public Boat save(Boat boat){
        return extensionesCrud.save(boat);
    }
    
     public void delete(Boat boat){
        extensionesCrud.delete(boat);
    }
}
    

