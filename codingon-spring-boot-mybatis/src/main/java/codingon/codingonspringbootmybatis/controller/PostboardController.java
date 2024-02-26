package codingon.codingonspringbootmybatis.controller;

import codingon.codingonspringbootmybatis.domain.Postboard;
import codingon.codingonspringbootmybatis.service.PostboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.sql.Timestamp;

@Controller
public class PostboardController {

    @Autowired
    PostboardService postboardService;

    @PostMapping ("/postboard")
    public String postInsert(@RequestParam String title, @RequestParam String content, @RequestParam String writer) {
        Postboard postboard = new Postboard();
        postboard.setTitle(title);
        postboard.setContent(content);
        postboard.setWriter(writer);
        postboardService.insertBoard(postboard);

//        return "redirect:/";
        return "postboard";
    }
}
