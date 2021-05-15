package com.handson.encryptdecrypt.service;

/**
 * Abstract base contract for text decryption.
 */
@FunctionalInterface
public interface DecryptionService {
    String decrypt(String encryptedText);
}