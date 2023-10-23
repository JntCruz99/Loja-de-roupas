package com.example.Loja.de.roupas.Controller.exceptions;

import lombok.Data;

import java.time.Instant;

@Data
public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String trace;
    private String message;
    private String path;
}
