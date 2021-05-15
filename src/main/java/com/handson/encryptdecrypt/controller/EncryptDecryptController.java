package com.handson.encryptdecrypt.controller;

import com.handson.encryptdecrypt.model.InputData;
import com.handson.encryptdecrypt.service.DecryptionService;
import com.handson.encryptdecrypt.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j2
@RequestMapping(value = "/api/v1/encrypt-decrypt")
public class EncryptDecryptController {

    private final EncryptionService encryptionService;
    private final DecryptionService decryptionService;

    @PostMapping(value = "/encrypt", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> encrypt(@RequestBody InputData inputData) {
        return ResponseEntity.ok(encryptionService.encrypt(inputData.getInput()));
    }

    @PostMapping( value = "/decrypt", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> decrypt(@RequestBody InputData inputData) {
        return ResponseEntity.ok(decryptionService.decrypt(inputData.getInput()));
    }
}