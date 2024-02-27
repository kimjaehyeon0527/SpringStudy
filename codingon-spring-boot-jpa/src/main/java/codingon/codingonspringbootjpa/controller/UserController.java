package codingon.codingonspringbootjpa.controller;

import codingon.codingonspringbootjpa.dto.UserDTO;
import codingon.codingonspringbootjpa.entity.UserEntity;
import codingon.codingonspringbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";

    }
    @PostMapping("/insert")
    @ResponseBody
    public String insertUser(@RequestBody UserEntity user) {
        String newName = userService.insertUser(user);
        return newName + " Success";
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkName(@RequestParam String name) {
        // name 을 param 으로 받아서 그런 이름을 가진 사용자가 있는지 여부를 return
        boolean result = userService.checkUser(name);
        if(result) return "있습니다.";
        else return "없습니다.";
    }

    @GetMapping("/checkNum")
    @ResponseBody
    public String checkNameNum(@RequestParam String name) {
        List<UserEntity> result = userService.checkUserNum(name);
        return  result.size() + "명";
    }

//    @GetMapping("/checkSearch")
//    @ResponseBody
//    public String checkNameNickNameNum(@RequestParam String name, String nickname) {
//        List<UserEntity> result = userService.checkUserNameNickName(name, nickname);
//        return result.size() + "명";
//    }

    @GetMapping("/nickname")
    @ResponseBody
    public String findNameOrNickname(@RequestParam String word) {
        // 검색어 word 를 입력 받고, 이름이 word 이거나 닉네임이 word 인 사람이 몇명인지 조회.
        int cnt = userService.searchNameOrNickname(word);
        return cnt + "명 입니다.";
    }

    @GetMapping("/search")
    @ResponseBody
    public String searchUser(@RequestParam String name) {
        // query string 으로 받아온 name 값으로 검색해서 검색된 객체의 아이디와 닉네임 보여줌.
        return userService.searchUser(name);
    }

    @GetMapping("/searchid")
    @ResponseBody
    public String searchId(@RequestParam int id) {
        // Optional 확인용 아이디로 찾기.
        return userService.searchId(id);
    }
}
