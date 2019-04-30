package com.mgavino.springbootmicroserviceuserservice.model;

import com.mgavino.utils.model.IdentifyEntity;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class UserEntity extends IdentifyEntity {

    private String firstName;
    private String lastName;
    private String email;

    public UserEntity() {}

    public UserEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
