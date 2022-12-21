package com.usa.mintic.inqbike3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="tb_message")
public class Message implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer idMessage;
    private String messageText;


    private String quadbike;
    private String description;
    private String client;





    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getQuadbike() {
        return quadbike;
    }

    public void setQuadbike(String quadbike) {
        this.quadbike = quadbike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
