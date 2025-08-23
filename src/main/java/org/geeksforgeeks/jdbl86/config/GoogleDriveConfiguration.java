package org.geeksforgeeks.jdbl86.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleDriveConfiguration {

    @Bean
    public GoogleDrive makeGoogleDrive() {
        this.something();
        return new GoogleDrive();
    }

    private void something() {
        // Some complicated logic according Google documentation
    }

}

