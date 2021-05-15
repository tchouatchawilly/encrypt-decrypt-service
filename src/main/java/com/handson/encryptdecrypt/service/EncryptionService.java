package com.handson.encryptdecrypt.service;

@FunctionalInterface
public interface EncryptionService {
    String encrypt(String plainText);
}