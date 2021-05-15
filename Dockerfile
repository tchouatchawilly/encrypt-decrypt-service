FROM adoptopenjdk/openjdk11

ARG $GOOGLE_APPLICATION_CREDENTIALS

LABEL GOOGLE_APPLICATION_CREDENTIALS=$GOOGLE_APPLICATION_CREDENTIALS

WORKDIR /deployments/app/

EXPOSE 8080

COPY ./target/encrypt-decrypt-exec.jar /deployments/app/

ENTRYPOINT ["java", "-jar", "encrypt-decrypt-exec.jar"]