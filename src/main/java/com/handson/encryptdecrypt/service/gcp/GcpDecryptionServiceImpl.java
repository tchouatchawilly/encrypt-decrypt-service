package com.handson.encryptdecrypt.service.gcp;

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;
import com.handson.encryptdecrypt.service.DecryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Base64;

@ConditionalOnProperty(prefix = "encryption.provider.gcp", name = "enabled", havingValue = "true")
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Log4j2
public class GcpDecryptionServiceImpl implements DecryptionService {

    private final KeyManagementServiceClient client;
    private final CryptoKeyName cryptoKeyName;

    @Override
    public String decrypt(String encryptedText) {
        var value = Base64.getDecoder().decode(encryptedText);
        DecryptResponse response = client.decrypt(cryptoKeyName, ByteString.copyFrom(value));
        return response.getPlaintext().toStringUtf8();
    }
}
