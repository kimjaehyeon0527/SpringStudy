package codingon.codingonspringbootmybatis.service;

import codingon.codingonspringbootmybatis.domain.Postboard;
import codingon.codingonspringbootmybatis.dto.PostboardDTO;
import codingon.codingonspringbootmybatis.mapper.PostboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostboardService {
    @Autowired
    PostboardMapper postboardMapper;

    public void insertBoard(Postboard postboard) {
        postboardMapper.insertBoard(postboard);
    }
}
