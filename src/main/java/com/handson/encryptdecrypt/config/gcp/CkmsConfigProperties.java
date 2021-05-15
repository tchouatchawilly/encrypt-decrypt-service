package com.handson.encryptdecrypt.config.gcp;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConditionalOnProperty(prefix = "encryption.provider.gcp", name = "enabled", havingValue = "true")
@ConfigurationProperties(prefix = "encryption.provider.gcp")
@Data
public class CkmsConfigProperties {
    private String projectId;
    private String locationId;
    private String keyRingId;
    private String keyId;
}
