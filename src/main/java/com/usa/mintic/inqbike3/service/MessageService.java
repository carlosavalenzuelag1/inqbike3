package com.usa.mintic.inqbike3.service;


import com.usa.mintic.inqbike3.entities.Message;
import com.usa.mintic.inqbike3.entities.Reservation;
import com.usa.mintic.inqbike3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message  message) {
        if ( message.getIdMessage() == null) {
            return messageRepository.save( message);
        } else {
            Optional<Message>  message1 = messageRepository.getMessage( message.getIdMessage());
            if ( message1.isPresent()) {
                return  message;
            } else {
                return messageRepository.save( message);

            }
        }
    }

    public Message update(Message  message) {

        if ( message.getIdMessage() != null) {
            Optional<Message> qk = messageRepository.getMessage( message.getIdMessage());
            if (qk.isPresent()) {
                if ( message.getIdMessage() != null) {
                    qk.get().setIdMessage( message.getIdMessage());
                }

                if ( message.getMessageText() != null) {
                    qk.get().setMessageText( message.getMessageText());
                }

                if ( message.getQuadbike() != null) {
                    qk.get().setQuadbike( message.getQuadbike());
                }

                if ( message.getDescription() != null) {
                    qk.get().setDescription( message.getDescription());
                }

                if ( message.getClient() != null) {
                    qk.get().setClient( message.getClient());
                }

                messageRepository.save(qk.get());

                return qk.get();


            } else {
                return message;
            }


        } else {
            return  message;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Message>p= messageRepository.getMessage(id);
        if(p.isPresent()){
            messageRepository.delete(p  .get());
            flag=true;

        }
        return flag;

    }

}
