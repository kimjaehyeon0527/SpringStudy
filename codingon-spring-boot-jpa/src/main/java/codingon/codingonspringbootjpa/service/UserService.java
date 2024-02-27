package codingon.codingonspringbootjpa.service;

import codingon.codingonspringbootjpa.dto.UserDTO;
import codingon.codingonspringbootjpa.entity.UserEntity;
import codingon.codingonspringbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getUserList() {
        // repository 에서 전체 조회 가능하도록
        // findAll() JpaRepository 인터페이스에 정의되어 있는 메소드

        List<UserEntity> users = userRepository.findAll();
//        DB 구조라 일치하니깐 UserEntity 타입으로
        List<UserDTO> result = new ArrayList<>();
//        받아온 값을 result 에 담아 준다.

        for (UserEntity user: users) {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .no(user.getId() + 100)
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();

            result.add(userDTO);
        }
        return result;
    }

    public String insertUser(UserEntity user) {
        // jpa save(T) 메소드 : T 는 Entity
        // - insert 할 때
        // - 기존 entity 를 update 할 때
        // => 기본 값(pk) 상태에 따라 다르게 동작
        // pk 가 존재한다면 pk 와 연결된 entity update
        // pk 가 없는 경우, 새로운 entity insert

        UserEntity newUser = userRepository.save(user);
        // 새로 생긴 애를 바로 반환 해준다.
        // save 를 했을 때 반환되는 객체는 Entity 객체
        return newUser.getName();
    }

    public boolean checkUser(String name) {
        return userRepository.existsByName(name);
    }

    public List<UserEntity> checkUserNum(String name) {
        return userRepository.findByName(name);
    }

//    public List<UserEntity> checkUserNameNickName(String name, String nickname) {
//        return userRepository.findByNameOrNickname(name, nickname);
//    }

    public int searchNameOrNickname(String word) {
        List<UserEntity> result = userRepository.findByNameOrNickname(word, word);
        return result.size();
    }

    public String searchUser(String name) {
        List<UserEntity> result = userRepository.findByName(name);
        for (UserEntity user : result) {
            System.out.println(user.getId() + user.getNickname());
        }
        return result.size() + "명 입니다.";
    }

    public String searchId(int id) {
        Optional<UserEntity> result = userRepository.findById(id);
        // get() : Optional 내부에 담긴 객체 반환
        // - 만약 null 이라면 NoSuchElementException 발생
        // isPresent() : 객체의 여부를 boolean 값으로 반환
        // orElse() : 있으면 반환하고 없으면 다른 값 반환
        // - orElse Optional.orElse()
//        UserEntity user = userRepository.findById(id).orElseThrow(() => new RuntimeException("user doesn't exist"));

        if (result.isPresent()) {
            return result.get().getName();
        } else {
            return "no User";
        }
    }

}
