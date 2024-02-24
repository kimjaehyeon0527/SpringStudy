package codingon.codingonspringbootmybatis.mapper;

import codingon.codingonspringbootmybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 스프링 부트에게 매퍼 역할을 하는 인터페이스임을 알림.
public interface UserMapper {
    // sql 과 객체를 매핑해주는 곳으로 실제 DB 접속할 때 실행할 sql 문 정의

    // Case 1. xml 파일 (mapper 파일) 참고
    // xml 파일을 따로 분리한 경우
    List<User> retrieveAll();
    // UserMapper.xml 의 id 값과 함수 이름이 같아야 함.

    // Case 2. xml 파일 (mapper 파일) 참고하지 않고, sql 을 실행
    // xml 파일을 같이 쓴 경우
    // 어노테이션을 이용하여 직접 sql 문을 적어주는 방법.
    @Insert("insert into user(name, nickname) values(#{name}, #{nickname})")
    void insertUser(User user);
    // void insertUser(String name, String nickname);

}
