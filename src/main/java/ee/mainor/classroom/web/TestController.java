package ee.mainor.classroom.web;

import ee.mainor.classroom.service.TEst1;
import ee.mainor.classroom.service.Test2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String sayHello() {
        return "s";
    }

    @GetMapping("goodbye")
    public String sayGoodbye() {
        return "Goodbye!";
    }

}
