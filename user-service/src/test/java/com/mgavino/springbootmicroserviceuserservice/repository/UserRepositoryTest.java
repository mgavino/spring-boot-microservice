package com.mgavino.springbootmicroserviceuserservice.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mgavino.springbootmicroserviceuserservice.model.UserEntity;
import com.mgavino.springbootmicroserviceuserservice.repository.UserRepository;
import com.mgavino.utils_test.model.CrudRepositoryTest;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest extends CrudRepositoryTest<UserEntity> {

    @Autowired
    private UserRepository repository;

    @Override
    protected UserEntity createEntity() {
        UserEntity entity = new UserEntity();
        entity.setFirstName("Manuel");
        entity.setLastName("Gavino");
        entity.setEmail("manueljesusgavino@gmail.com");
        return entity;
    }

    @Override
    protected UserEntity updateEntity(UserEntity entity) {
        entity.setFirstName("Manuel Updated");
        return entity;
    }

    @Override
    protected void assertSave(UserEntity entity) {
        Assert.assertEquals("Manuel", entity.getFirstName());
        Assert.assertEquals("Gavino", entity.getLastName());
    }

    @Override
    protected void assertUpdate(UserEntity entity) {
        Assert.assertEquals("Manuel Updated", entity.getFirstName());
        Assert.assertEquals("Gavino", entity.getLastName());
    }

    @Override
    protected void assertGet(UserEntity entity) {
        Assert.assertEquals("Manuel", entity.getFirstName());
        Assert.assertEquals("Gavino", entity.getLastName());
    }

    @Test
    public void initValues() {
        repository.save(createEntity());
    }
}
