package com.mgavino.springbootmicroservicepostservice.model;

import com.mgavino.utils.model.IdentifyEntity;
import org.bson.types.ObjectId;

public class PostEntity extends IdentifyEntity {

    private String title;
    private String description;

    private String author;

    public PostEntity() {}

    public PostEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
