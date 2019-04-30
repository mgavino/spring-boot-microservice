package com.mgavino.springbootmicroservicepostservice.repository;

import com.mgavino.springbootmicroservicepostservice.model.PostEntity;
import com.mgavino.utils_test.model.CrudRepositoryTest;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest extends CrudRepositoryTest<PostEntity> {

    @Autowired
    private PostRepository repository;

    @Override
    protected PostEntity createEntity() {
        PostEntity entity = new PostEntity();
        entity.setTitle("Manu's post");
        entity.setDescription("Description");
        entity.setAuthor("manueljesusgavino@gmail.com");
        return entity;
    }

    @Override
    protected PostEntity updateEntity(PostEntity entity) {
        entity.setTitle("Manu's post Updated");
        return entity;
    }

    @Override
    protected void assertSave(PostEntity entity) {
        Assert.assertEquals("Manu's post", entity.getTitle());
        Assert.assertEquals("Description", entity.getDescription());
    }

    @Override
    protected void assertUpdate(PostEntity entity) {
        Assert.assertEquals("Manu's post Updated", entity.getTitle());
        Assert.assertEquals("Description", entity.getDescription());
    }

    @Override
    protected void assertGet(PostEntity entity) {
        Assert.assertEquals("Manu's post", entity.getTitle());
        Assert.assertEquals("Description", entity.getDescription());
    }

    @Test
    public void initValues() {
        repository.save(createEntity());
    }
}
