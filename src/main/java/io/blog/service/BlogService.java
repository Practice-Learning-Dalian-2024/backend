package io.blog.service;

import io.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogMapper mapper;

    @Autowired
    public BlogService(BlogMapper mapper) {
        this.mapper = mapper;
    }

    public void delete(int id) {
        mapper.delete(id);
    }
}
