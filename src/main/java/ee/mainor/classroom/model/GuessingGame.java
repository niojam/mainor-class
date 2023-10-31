package ee.mainor.classroom.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "GUESSING_GAME")
public class GuessingGame {

    @Id
    private Long id;
    private Long correctAnswer;
    private String name;

}
