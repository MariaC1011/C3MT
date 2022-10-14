/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Message;
import com.example.demo.Repositorio.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getCategory(int id){
        return messageRepository.getMessage(id);
    }
    public Message save (Message message){
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        }else {
            Optional<Message> category1 = messageRepository.getMessage(message.getIdMessage());
            if (category1.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Optional<Message> getMessage(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
