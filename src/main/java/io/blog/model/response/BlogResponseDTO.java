package io.blog.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponseDTO {
    private int id;
    private int author;
    private String title;
    private String content_path;
    private long time;
    private short category;
    private int visitor_count;  // TODO: Need query
    private int like_count;     // TODO: Need query
    private int status;
    private String brief;
}
