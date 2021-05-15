# encrypt-decrypt-service: Design a Symmetric encryption Api

As a Key management system, we are using Google's Cloud Key Management Service and create a symmetric keys for encryption/decryption process.
We are using CKMS here for keys generation and managing life cycle of keys as well(keys rotation, expiration).

The algorithm use for encryption is GOOGLE_SYMMETRIC_ENCRYPTION algorithm. This algorithm uses 256-bit Advanced Encryption Standard (AES-256) keys in Galois Counter Mode (GCM), padded with Cloud KMS-internal metadata.

# Test encryption and decryption Rest endpoint

Enable the CKMS service in your google app and confire the following settings in the application.yml file:

project-id: {PROJECT_ID}<br />
location-id: {LOCATION_ID}<br />
key-ring-id: {KEY_RING_ID}<br />
key-id: {KEY_ID}<br />

Before starting the App, configure this environment variable GOOGLE_APPLICATION_CREDENTIALS to point to your google service account credentials(a JSON file).
Find a sample in resources folder gcp-service-credentials.json
Start the app and consume :<br/>
POST http://localhost:8080/api/v1/encrypt-decrypt/encrypt <br/>
    {<br/>
      "input": "Text to encrypt"<br/>
    }<br/>
Response: Encrypted text.<br/>

POST http://localhost:8080/api/v1/encrypt-decrypt/decrypt <br/>
{<br/>
"input": "Encrypted Text"<br/>
}<br/>
Response: Decrypted text.



# References
1. https://cloud.google.com/kms/docs/creating-keys
2. https://github.com/google/tink/blob/master/docs/JAVA-HOWTO.md
3. https://cloud.google.com/kms/docs/algorithms?_ga=2.223053074.-802941337.1620944737
