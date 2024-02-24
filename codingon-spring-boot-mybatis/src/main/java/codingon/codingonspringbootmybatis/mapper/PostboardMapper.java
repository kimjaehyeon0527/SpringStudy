package codingon.codingonspringbootmybatis.mapper;

import codingon.codingonspringbootmybatis.domain.Postboard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostboardMapper {
    @Insert("INSERT INTO postboard (id, title, content, writer, registered) VALUES (#{id}, #{title}, #{content}, #{writer}, #{registered})")
    void insertBoard(Postboard postboard);

}
