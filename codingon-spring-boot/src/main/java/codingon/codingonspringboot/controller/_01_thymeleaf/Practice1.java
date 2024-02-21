package codingon.codingonspringboot.controller._01_thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Practice1 {
    @GetMapping("/prac01")
    public String prac(Model model) {

//      내가 한것.
//        AgePrint ageprint = new AgePrint(18);
//        model.addAttribute("agePrint", ageprint);

        model.addAttribute("age", 18);


//        ArrayList<Person> people = new ArrayList<>();
//
//        Person person1 = new Person("김", 20);
//        Person person2 = new Person("수", 15);
//        Person person3 = new Person("한", 25);
//        Person person4 = new Person("무", 19);
//
//        people.add(person1);
//        people.add(person2);
//        people.add(person3);
//        people.add(person4);
//
//        model.addAttribute("Person", people);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("홍길동", 10));
        persons.add(new Person("성춘향", 11));
        persons.add(new Person("김민지", 12));
        persons.add(new Person("강해린", 13));

        model.addAttribute("persons", persons);

        return "_01_thymeleaf/prac01";
    }
}

class AgePrint {
    private int age;

    public AgePrint(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

@Getter // getter 사용
@Setter
@AllArgsConstructor // 모든 필드 값을 매개변수로 받는 생성자.
class Person {
    private String name;
    private int age;

    // 어노테이션으로 인해 이런거 안해도 된다.
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
}
