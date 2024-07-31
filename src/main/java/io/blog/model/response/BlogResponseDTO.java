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
    private String time;
    private short category;
    private int visitor_count;
    private int like_count;
    private int status;
    private String brief;
}
