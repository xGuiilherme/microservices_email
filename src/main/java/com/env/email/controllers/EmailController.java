package com.env.email.controllers;

import com.env.email.dtos.EmailDto;
import com.env.email.models.EmailModel;
import com.env.email.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/sending-email", consumes = {"application/xml", "application/json"})
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel); // faz a conversao de DTO para model <?, ?>.
        emailService.sendEmail(emailModel); // metodo para salva e enviar o email <sendEmail>.
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
