// package com.example.authapp;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class AuthAppApplication {
//     public static void main(String[] args) {
//         SpringApplication.run(AuthAppApplication.class, args);
//     }
// }
package com.example.authapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AuthAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthAppApplication.class, args);
    }
}
