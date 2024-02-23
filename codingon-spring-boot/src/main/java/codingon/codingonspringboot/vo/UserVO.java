package codingon.codingonspringboot.vo;

import lombok.Getter;

import java.util.Objects;

@Getter // VO는 값 변경이 없기 떄문에 Getter 만!
public class UserVO {
    private String name;
    private String age;

    // 동등성 (값이 같은지 판단하기 위해서) 구현을 위한 코드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 주소가 같으면 바로 끝
        if (o == null || getClass() != o.getClass()) return false; // 정보가 다르면 false 보내기

        // 둘다 아니면
        UserVO userVO = (UserVO) o; // 형변환

        // 여기서 모든 필드를 비교
        return Objects.equals(name, userVO.name) && Objects.equals(age, userVO.age);
    }

    @Override
    public int hashCode() {
        // 필드들을 이용한 해시코드를 생성
        return Objects.hash(name, age);
    }
}
