package ee.mainor.classroom.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("goodbye")
    public String sayGoodbye() {
        return "Goodbye!";
    }

}
