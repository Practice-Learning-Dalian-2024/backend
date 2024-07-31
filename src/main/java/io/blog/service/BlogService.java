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

    public void delete(int id) {
        mapper.delete(id);
    }

    public void create(BlogRequestDTO blog) {
        mapper.create(blog);
    }

    public void update(BlogRequestDTO blog) {
        mapper.update(blog);
    }

    public BlogResponseDTO read(int id) {
        return mapper.read(id);
        // TODO: Query like, view, comment
    }

    public List<BlogResponseDTO> readAll() {
        return mapper.readAll();
    }

    public List<BlogResponseDTO> readByCategory(int category) {
        return mapper.readByCategory(category);
    }

    public List<BlogResponseDTO> readMostPopularBlogs(int userId) {
        return mapper.readMostPopularBlogs(userId);
    }

    public List<BlogResponseDTO> readLatestBlogsByUser(int author) {
        return mapper.readLatestBlogsByUser(author);
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
