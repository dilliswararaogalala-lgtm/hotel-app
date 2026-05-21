package com.step.hotel_app.repository;

import com.step.hotel_app.models.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<AppUser, String> {

}
