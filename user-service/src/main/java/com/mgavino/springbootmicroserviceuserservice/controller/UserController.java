package com.mgavino.springbootmicroserviceuserservice.controller;

import com.mgavino.springbootmicroserviceuserservice.feign.PostService;
import com.mgavino.springbootmicroserviceuserservice.feign.conversion.PostConversionBean;
import com.mgavino.springbootmicroserviceuserservice.model.UserEntity;
import com.mgavino.utils.controller.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<UserEntity> {

    @Autowired
    private PostService postProxy;

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<PostConversionBean>> getPosts(@PathVariable("id") String id) {

        ResponseEntity<UserEntity> userResponse = get(id);
        if (HttpStatus.OK.equals(userResponse.getStatusCode())) {

            List<PostConversionBean> posts = postProxy.search(userResponse.getBody().getEmail());
            if (posts != null && !posts.isEmpty()) {
                return new ResponseEntity<List<PostConversionBean>>(posts, HttpStatus.OK);
            }

        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


}
