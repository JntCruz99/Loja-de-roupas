package com.example.Loja.de.roupas.Controller;

import com.example.Loja.de.roupas.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkouts")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<?> postCheckout(){
        return ResponseEntity.status(HttpStatus.OK).body(checkoutService.fazerSolicitacaoPost());
    }
}
