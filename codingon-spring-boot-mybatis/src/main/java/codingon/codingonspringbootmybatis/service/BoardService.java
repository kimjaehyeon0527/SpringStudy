package codingon.codingonspringbootmybatis.service;

import codingon.codingonspringbootmybatis.domain.Board;
import codingon.codingonspringbootmybatis.dto.BoardDTO;
import codingon.codingonspringbootmybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    // Mapper 에 있는 함수 호출해서 sql 문 실행 할 것
    // BoardMapper 객체 필요.
    // 안에 있는 메소드들 사용하기 위해!
    // 의존성 주입으로 가져오기
    @Autowired
    BoardMapper boardMapper;

    public List<BoardDTO> getAll() {
        // getAll() 메소드는 "select * from board" sql 을 실행하는 함수
        List<Board> result = boardMapper.getAll();
        List<BoardDTO> list = new ArrayList<>();

        // Board 타입으로 도는 result 을 for each 로 만들기
        for(Board board : result) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(board.getRegistered())
                    .no(board.getWriter() + board.getId())
                    .build();

            list.add(boardDTO);
        }
        return list;
        // 전체 정보에 대해서 메소드를 완성.
    }

    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    public void patchBoard(Board board) {
        boardMapper.patchBoard(board);
    }

    public void deleteBoard(int id) {
        boardMapper.deleteBoard(id);
    }

    public int searchBoard(String word) {
        // Select 문 자체를 count 로 동작시킬 수도 있고,
        // List 로 받아와서 그에 대한 길이를 전달할 수도 있다.
        List<Board> result = boardMapper.searchBoard(word);
        return result.size();
    }
}
