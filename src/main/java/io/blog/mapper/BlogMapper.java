package io.blog.mapper;

import io.blog.model.request.BlogRequestDTO;
import io.blog.model.response.BlogResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    void create(BlogRequestDTO blog);

    void update(BlogRequestDTO blog);

    void delete(int id);

    BlogResponseDTO read(int id);

    List<BlogResponseDTO> readAll();
}
