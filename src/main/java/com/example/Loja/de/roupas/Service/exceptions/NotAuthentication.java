package com.example.Loja.de.roupas.Service.exceptions;

public class NotAuthentication extends RuntimeException{
    public NotAuthentication(String msg){
        super(msg);
    }
}
