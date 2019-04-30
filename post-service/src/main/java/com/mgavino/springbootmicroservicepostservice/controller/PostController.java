package com.mgavino.springbootmicroservicepostservice.controller;

import com.mgavino.springbootmicroservicepostservice.model.PostEntity;
import com.mgavino.springbootmicroservicepostservice.repository.PostRepository;
import com.mgavino.utils.controller.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController extends CrudController<PostEntity> {

    @Autowired
    private PostRepository repository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<PostEntity>> search(@RequestParam("author") String author) {

        List<PostEntity> entities = repository.findByAuthor(author);
        if (entities == null || entities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<PostEntity>>(entities, HttpStatus.OK);
    }

}
