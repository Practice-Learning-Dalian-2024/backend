package io.blog.service;

import io.blog.mapper.BlogMapper;
import io.blog.model.request.BlogRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogMapper mapper;

    @Autowired
    public BlogService(BlogMapper mapper) {
        this.mapper = mapper;
    }

    // TODO: Check if the blog exists
    public void delete(int id) {
        mapper.delete(id);
    }

    // TODO: Check if the blog exists
    public void create(BlogRequestDTO blog) {
        mapper.create(blog);
    }

    // TODO: Check if the blog exists
    public void update(BlogRequestDTO blog) {
        mapper.update(blog);
    }
}
