package ee.mainor.classroom.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Accessors(chain = true)
@Table(name = "guessing_game")
public class GuessingGame {

    @Id
    private Long id;
    private Integer correctAnswer;
    private String name;

}
