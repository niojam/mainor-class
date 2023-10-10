package ee.mainor.classroom.web;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

//    private final PersonRepository personRepository;

    @GetMapping("hello")
    public String sayHello() {
//        Person entity = new Person();
//        entity.setCity("Tallinn");
//        return personRepository.save(entity).getCity();
        return "";
    }

    @GetMapping("goodbye")
    public String sayGoodbye() {
        return "Goodbye!";
    }

}
