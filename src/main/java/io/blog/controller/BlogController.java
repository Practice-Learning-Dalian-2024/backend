package io.blog.controller;

import io.blog.util.Response;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogController {
    // TODO
    @GetMapping("/{id}")
    public Response<?> getBlog(@PathVariable int id) {
        throw new RuntimeException("TODO"); // TODO
    }

    @GetMapping("/dashboard/{id}")
    public Response<?> getDashboard(@PathVariable int id) {
        throw new RuntimeException("TODO"); // TODO
    }

    @PostMapping("/new")
    public Response<?> newBlog(@RequestBody String content) {
        throw new RuntimeException("TODO"); // TODO
    }

    @PutMapping("/edit")
    public Response<?> editBlog(@RequestBody String content) {
        throw new RuntimeException("TODO"); // TODO
    }

    @DeleteMapping("/del")
    public Response<?> deleteBlog(@RequestBody String content) {
        throw new RuntimeException("TODO"); // TODO
    }

    @PostMapping("/like")
    public Response<?> likeBlog(@RequestBody String content) {
        throw new RuntimeException("TODO"); // TODO
    }

    @PostMapping("/comment")
    public Response<?> commentBlog(@RequestBody String content) {
        throw new RuntimeException("TODO"); // TODO
    }
}
