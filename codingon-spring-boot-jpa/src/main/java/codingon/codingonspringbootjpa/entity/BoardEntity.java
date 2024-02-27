package codingon.codingonspringbootjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity // 해당 클래스가 Entity 클래스임을 명시. (반드시 추가하기)
@Getter
@Builder    // 객체 생성 처리
@AllArgsConstructor // 모든 필드를 사용하는 생성자
@NoArgsConstructor  // 매개변수가 없는 생성자 (기본 생성자)
@Table(name = "user")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 사용 옵션
    private int id;

    @Column(nullable = false, length = 20) // varchar(20)
    private String name; // 만약, 컬럼명이 다르다면 name="text" 로 매핑시킬 컬럼명 적어주면 된다.

    // 타입 : text (varchar X)
    @Column(columnDefinition = "Text")
    private String nickname;
//    @CreationTimestamp

}
