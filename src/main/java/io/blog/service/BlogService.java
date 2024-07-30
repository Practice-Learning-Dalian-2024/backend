package io.blog.service;

import io.blog.mapper.BlogMapper;
import io.blog.model.request.BlogRequestDTO;
import io.blog.model.request.LikeRequestDTO;
import io.blog.model.response.BlogResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public BlogResponseDTO read(int id) {
        BlogResponseDTO blog = mapper.read(id);
        throw new RuntimeException("TODO"); // TODO
    }

    public List<BlogResponseDTO> readAll() {
        return mapper.readAll();
    }

    public void like(LikeRequestDTO like) {
        int blogId = like.getBlogId();
        if (mapper.ifLikeBlog(like)) {
            mapper.unlikeBlog(like);
            mapper.unlikeBlogCount(blogId);
        } else {
            mapper.likeBlog(like);
            mapper.likeBlogCount(blogId);
        }
    }
}
