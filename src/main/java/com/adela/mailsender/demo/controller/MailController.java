package com.adela.mailsender.demo.controller;

import com.adela.mailsender.demo.service.EmailService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequest request) {
        emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
        System.out.println("Enviando correo...");
        return ResponseEntity.ok("Correo enviado a " + request.getTo());
    }
}
