package io.blog.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDTO {
    //    INSERT INTO blog (author, title, content_path, category, brief)
//    VALUES (#{author}, #{title}, #{contentPath}, #{category}, #{brief})
    private int author;
    private String title;
    private String contentPath;
    private short category;
    private String brief;
}
