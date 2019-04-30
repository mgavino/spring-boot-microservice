package com.mgavino.springbootmicroservicepostservice.repository;

import com.mgavino.springbootmicroservicepostservice.model.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * In a typical Java application, you write a class that implements
 * UserRepository and craft the queries yourself.
 * What makes Spring Data MongoDB so useful is the fact that you
 * don’t have to create this implementation. Spring Data MongoDB
 * creates it on the fly when you run the application.
 */
@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {

    public List<PostEntity> findByTitle(String title);
    public List<PostEntity> findByDescription(String description);
    public List<PostEntity> findByAuthor(String author);

}
