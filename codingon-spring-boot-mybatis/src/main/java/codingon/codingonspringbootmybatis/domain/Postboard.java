package codingon.codingonspringbootmybatis.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Postboard {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Timestamp registered;
}


