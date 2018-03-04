package com.jzheadley.polipoll.server.config;

import de.bytefish.fcmjava.client.FcmClient;
import de.bytefish.fcmjava.http.options.IFcmClientSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseCloudMessagingConfiguration {

    @Bean
    public IFcmClientSettings buildFcmSettings() {
        return new IFcmClientSettings() {
            @Override
            public String getFcmUrl() {
                return "https://fcm.googleapis.com/fcm/send";
            }

            @Override
            public String getApiKey() {
                return "AAAA1whj4DI:APA91bGHO1lNpAurIBH7btMP3-wKjUrOh8dGmBuci5ejUt3cxgHfOgYqvbz7rPx_MUFR2AMXX7NcofTjmzg9E9K6QZTeSm75Ien8_aTRNwYnkkW1zsN_lfc9N2M9Ik87vCNQ_mykfmRG";
            }
        };
    }

    @Bean
    public FcmClient buildFcmClient(IFcmClientSettings fcmClientSettings) {
        return new FcmClient(fcmClientSettings);
    }
}
