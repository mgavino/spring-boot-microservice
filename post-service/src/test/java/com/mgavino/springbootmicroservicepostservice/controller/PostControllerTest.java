package com.mgavino.springbootmicroservicepostservice.controller;

import com.mgavino.springbootmicroservicepostservice.model.PostEntity;
import com.mgavino.utils_test.controller.CrudControllerTest;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest extends CrudControllerTest<PostEntity> {

    private static final String URI = "/post";

    @Override
    protected String getUri() {
        return URI;
    }

    @Override
    protected PostEntity createEntity() {
        PostEntity entity = new PostEntity();
        entity.setTitle("Manu's post");
        entity.setDescription("Description");
        entity.setAuthor("manueljesusgavino@gmail.com");
        return entity;
    }

    @Override
    protected PostEntity createPathEntity() {
        PostEntity entity = new PostEntity();
        entity.setTitle("Manu's post Updated Path");
        return entity;
    }

    @Override
    protected PostEntity updatePutEntity(PostEntity entity) {
        entity.setTitle("Manu's post Updated Put");
        return entity;
    }

    @Override
    protected void assertPost(PostEntity entity) {
        Assert.assertEquals("Manu's post", entity.getTitle());
        Assert.assertEquals("Description", entity.getDescription());
    }

    @Override
    protected void assertPut(PostEntity entity) {
        Assert.assertEquals("Manu's post Updated Put", entity.getTitle());
        Assert.assertEquals("Description", entity.getDescription());
    }

    @Override
    protected void assertPath(PostEntity entity) {
        Assert.assertEquals("Manu's post Updated Path", entity.getTitle());
        Assert.assertEquals("Description", entity.getDescription());
    }

    @Override
    protected void assertGet(PostEntity entity) {
        Assert.assertEquals("Manu's post", entity.getTitle());
        Assert.assertEquals("Description", entity.getDescription());
    }

}
