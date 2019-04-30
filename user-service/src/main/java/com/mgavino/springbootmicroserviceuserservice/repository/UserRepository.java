package com.mgavino.springbootmicroserviceuserservice.repository;

import com.mgavino.springbootmicroserviceuserservice.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Collection;

/**
 * In a typical Java application, you write a class that implements
 * UserRepository and craft the queries yourself.
 * What makes Spring Data MongoDB so useful is the fact that you
 * don’t have to create this implementation. Spring Data MongoDB
 * creates it on the fly when you run the application.
 */
@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    public Collection<UserEntity> findByFirstName(String firstName);
    public Collection<UserEntity> findByLastName(String lastName);

}
