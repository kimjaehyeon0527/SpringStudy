package codingon.codingonspringbootmybatis.mapper;

import codingon.codingonspringbootmybatis.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getAll();
    // 보드로 가져오는 값은 여러개 / Board 타입 List 로 받아주기
    void insertBoard(Board board);
    // C R U D 중 C R 2개 완성.

    void patchBoard(Board board);

    void deleteBoard(int id);

    List<Board> searchBoard(String word);
//        여러개 나올 수 있으니 List 로!
}
