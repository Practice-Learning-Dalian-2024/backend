package io.blog.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {
    private int blog;
    private int commenter;
    private boolean isNested;
    private Integer parent;
    private String content;
    private int timestamp;
    private int status;
}
