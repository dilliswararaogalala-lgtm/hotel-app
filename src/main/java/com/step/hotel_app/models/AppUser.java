package com.step.hotel_app.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class AppUser {
    @Id
    private String id;
    private final String username;
    private final String password;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
