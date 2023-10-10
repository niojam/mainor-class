package ee.mainor.classroom.service;

import ee.mainor.classroom.dto.GameCreateRequest;
import ee.mainor.classroom.dto.GameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GuessingGameService {

    private Map<Integer, Integer> games = new HashMap<>();
    private Random random = new Random();

    public Integer createGame(GameCreateRequest gameCreateRequest) {
        Integer id = random.nextInt();
        games.put(id, gameCreateRequest.getCorrectAnswer());
        return id;
    }

    public GameResponse guessNumber(Integer gameId, Integer guessableNumber) {
        Integer correctAnswer = games.get(gameId);
        GameResponse gameResponse = new GameResponse();
        if (guessableNumber.equals(correctAnswer)) {
            gameResponse.setText("You win");
        } else {
            gameResponse.setText("you lose");
        }

        return gameResponse;
    }

}
