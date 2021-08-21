package com.learning.spring.bootredis.api;
import java.util.Optional;

import com.learning.spring.bootredis.model.Blog;
import com.learning.spring.bootredis.repository.BlogRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BlogControllerApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogControllerApi.class);
    private BlogRepository blogRepository;

    BlogControllerApi(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @PostMapping("/blog")
    public Blog writeBlog(@RequestBody Blog blog) {
        blogRepository.save(blog);
        return blog;
    }

    @GetMapping("/blog/{id}")
    public Blog getBlog(@PathVariable String id) {
        LOGGER.info("Searching for blog with id {}", id);
        Optional<Blog> blog = blogRepository.findById(id);
        if (blog.isPresent()) {
            return blog.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found");
        }
    }
}
