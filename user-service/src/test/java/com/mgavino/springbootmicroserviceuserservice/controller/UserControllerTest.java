package com.mgavino.springbootmicroserviceuserservice.controller;

import com.mgavino.springbootmicroserviceuserservice.model.UserEntity;
import com.mgavino.utils_test.controller.CrudControllerTest;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends CrudControllerTest<UserEntity> {

    private static final String URI = "/user";

//    @Autowired
//    private MockMvc mockMvc;

    @Override
    protected String getUri() {
        return URI;
    }

    @Override
    protected UserEntity createEntity() {
        UserEntity entity = new UserEntity();
        entity.setFirstName("Manuel");
        entity.setLastName("Gavino");
        return entity;
    }

    @Override
    protected UserEntity createPathEntity() {
        UserEntity entity = new UserEntity();
        entity.setFirstName("Manuel Updated Path");
        return entity;
    }

    @Override
    protected UserEntity updatePutEntity(UserEntity entity) {
        entity.setFirstName("Manuel Updated Put");
        return entity;
    }

    @Override
    protected void assertPost(UserEntity entity) {
        Assert.assertEquals("Manuel", entity.getFirstName());
        Assert.assertEquals("Gavino", entity.getLastName());
    }

    @Override
    protected void assertPut(UserEntity entity) {
        Assert.assertEquals("Manuel Updated Put", entity.getFirstName());
        Assert.assertEquals("Gavino", entity.getLastName());
    }

    @Override
    protected void assertPath(UserEntity entity) {
        Assert.assertEquals("Manuel Updated Path", entity.getFirstName());
        Assert.assertEquals("Gavino", entity.getLastName());
    }

    @Override
    protected void assertGet(UserEntity entity) {
        Assert.assertEquals("Manuel", entity.getFirstName());
        Assert.assertEquals("Gavino", entity.getLastName());
    }

//    @Test
//    public void posts() throws Exception {
//
//        String id = "5cb5d41d6fe4532c98f41ef5";
//
//        String contentResponse = mockMvc.perform(
//                MockMvcRequestBuilders.get(getUri() + "/" + id + "/posts")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string( Matchers.notNullValue() ))
//                .andReturn().getResponse().getContentAsString();
//
//    }

}
