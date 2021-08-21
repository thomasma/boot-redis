package com.learning.spring.bootredis.repository;


import com.learning.spring.bootredis.model.Blog;

import org.springframework.data.repository.CrudRepository;
public interface BlogRepository extends CrudRepository<Blog, String> {
}
