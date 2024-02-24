package codingon.codingonspringbootmybatis.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class PostboardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Timestamp registered;
    private int no;
}
