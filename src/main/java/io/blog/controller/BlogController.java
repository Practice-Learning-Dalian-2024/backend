package io.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.blog.model.request.BlogRequestDTO;
import io.blog.model.request.CommentRequestDTO;
import io.blog.model.request.LikeRequestDTO;
import io.blog.model.response.BlogResponseDTO;
import io.blog.service.BlogService;
import io.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogController {
    private final BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Response<?> getBlog(@PathVariable int id) {
        BlogResponseDTO blog = service.read(id);
        return new Response<>(200, "OK", blog);
    }

    @GetMapping("/dashboard/{id}")
    public Response<?> getDashboard(@PathVariable int id) {
        throw new RuntimeException("TODO"); // Deprecated
    }

    @PostMapping("/new")
    public Response<?> newBlog(@RequestBody BlogRequestDTO blog) {
        service.create(blog);
        return new Response<>(201, "Created", null);
    }

    @PutMapping("/edit")
    public Response<?> editBlog(@RequestBody BlogRequestDTO blog) {
        service.update(blog);
        return new Response<>(200, "Updated", null);
    }

    @DeleteMapping("/del")
    public Response<?> deleteBlog(@RequestBody String content)
            throws JsonProcessingException {
        JsonNode jn = new ObjectMapper().readTree(content);
        int id = jn.get("id").asInt();

        service.delete(id);

        return new Response<>(200, "Deleted", null);
    }

    @PostMapping("/like")
    public Response<?> likeBlog(@RequestBody LikeRequestDTO like) {
        service.like(like);
        return new Response<>(200, "OK", null);
    }

    @PostMapping("/comment")
    public Response<?> commentBlog(@RequestBody CommentRequestDTO comment) {
        throw new RuntimeException("TODO"); // TODO
    }

    @GetMapping("/latest")
    public Response<?> getLatestBlogs() {
        return new Response<>(200, "OK", service.readAll());
    }

    @GetMapping("/category/{category}")
    public Response<?> getBlogsByCategory(@PathVariable int category) {
        return new Response<>(200, "OK", service.readByCategory(category));
    }

    @GetMapping("/hot")
    public Response<?> getMostPopularBlogs(@RequestParam int userId) {
        return new Response<>(200, "OK", service.readMostPopularBlogs(userId));
    }

    @GetMapping("/latest/{author}")
    public Response<?> getLatestBlogsByUser(@PathVariable int author) {
        return new Response<>(200, "OK", service.readLatestBlogsByUser(author));
    }

    @GetMapping("/all/{author}")
    public Response<?> getBlogsByUser(@PathVariable int author) {
        return new Response<>(200, "OK", service.readBlogsByUser(author));
    }

    @GetMapping("/follow/{userId}")
    public Response<?> getFollowedBlogs(@PathVariable int userId) {
        return new Response<>(200, "OK", service.readFollowedBlogs(userId));
    }
}