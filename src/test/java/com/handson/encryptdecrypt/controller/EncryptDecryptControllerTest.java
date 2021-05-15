package com.handson.encryptdecrypt.controller;

import com.handson.encryptdecrypt.model.InputData;
import com.handson.encryptdecrypt.service.DecryptionService;
import com.handson.encryptdecrypt.service.EncryptionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class EncryptDecryptControllerTest {

    @Mock
    private EncryptionService encryptionService;

    @Mock
    private DecryptionService decryptionService;

    @InjectMocks
    EncryptDecryptController encryptDecryptController;

    @Test
    void testEncryptSuccess() {
        Mockito.when(encryptionService.encrypt(ArgumentMatchers.anyString())).thenReturn("encrypted");
        encryptDecryptController.encrypt(new InputData("plaintext"));
        verify(encryptionService, Mockito.times(1)).encrypt("plaintext");
        verifyNoInteractions(decryptionService);
    }

    @Test
    void testDecryptSuccess() {
        Mockito.when(decryptionService.decrypt(ArgumentMatchers.anyString())).thenReturn("decrypted");
        encryptDecryptController.decrypt(new InputData("encrypted"));
        verify(decryptionService, Mockito.times(1)).decrypt("encrypted");
        verifyNoInteractions(encryptionService);
    }
}