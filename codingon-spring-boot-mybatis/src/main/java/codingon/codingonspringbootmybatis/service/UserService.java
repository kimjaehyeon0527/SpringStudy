package codingon.codingonspringbootmybatis.service;

import codingon.codingonspringbootmybatis.domain.User;
import codingon.codingonspringbootmybatis.dto.UserDTO;
import codingon.codingonspringbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 로직 구현은 서비스 에서.

// @Service
// - 스프링 부트에게 서비스 계층임을 알림.
// - 해당 어노테이션이 없으면 컨트롤러에서 서비스 클래스를 찾을 수 없음.

@Service
// Service 어노테이션 안에 @Component 가 있어서 bean 으로 사용 가능.
public class UserService {
    // @Autowired
    // - 의존성 주입 (쉽게 말하면, 원하는 객체를 직접 생성하지 않고도 사용할 수 있도록 함.)
    @Autowired
    UserMapper userMapper;
    // userMapper 라는 객체를 이제 사용할 수 있게 됨.

    // getUserList()
    // - controller 에서 전체 조회를 하는 메소드.
    // - mapper 의 retrieveAll() 메소드를 실행 한다.

    // retrieveAll() 을 실행해야지 DB의 정보를 가져올 수 있다.

    public List<UserDTO> getUserList() {
        List<User> users = userMapper.retrieveAll();
        List<UserDTO> result = new ArrayList<>();
        // user 를 userDTO 로 보내주기 위해 변환 하는 과정.
        // userDTO 배열리스트를 만들어 user 정보들을 가져와 넣어준다.

        for (User user: users) {
            // Case 1. builder 패턴 사용하지 않는 경우
//            UserDTO userDTO = new UserDTO();
//
//            userDTO.setId(user.getId());
//            userDTO.setName(user.getName());
//            userDTO.setNickname(user.getNickname());
//            userDTO.setNo(user.getId() + 100);

            ///////////////////////
            // Case 2. builder 패턴 사용하는 경우
            // 순서가 상관이 없어지고, 명시적으로 입력값을 정해주었기 때문에 문제가 적다. 가독성도 좋아진다.
            // setter 를 이용하는 것보다 안전하다.
            // builder 로 만드는 경우에는 setter 를 안만든다.
            //
            UserDTO userDTO = UserDTO.builder()
                            .name(user.getName())
                            .nickname(user.getNickname())
                            .id(user.getId())
                            .no(user.getId() + 100).build();

            result.add(userDTO);
        }
        return result;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
