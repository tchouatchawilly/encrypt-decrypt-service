package com.handson.encryptdecrypt.config.gcp;

import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@ConditionalOnProperty(prefix = "encryption.provider.gcp", name = "enabled", havingValue = "true")
@Configuration
@EnableConfigurationProperties(CkmsConfigProperties.class)
public class GcpEncryptConfig {

    @Bean
    KeyManagementServiceClient keyManagementServiceClient() throws IOException {
        return KeyManagementServiceClient.create();
    }

    @Bean
    CryptoKeyName cryptoKeyName(CkmsConfigProperties properties) {
        return CryptoKeyName.of(
                properties.getProjectId(),
                properties.getLocationId(),
                properties.getKeyRingId(),
                properties.getKeyId()
        );
    }
}
