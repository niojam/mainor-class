package ee.mainor.classroom.service;

import ee.mainor.classroom.dto.GameCreateRequest;
import ee.mainor.classroom.dto.GameDto;
import ee.mainor.classroom.dto.GameResponse;
import ee.mainor.classroom.model.GuessingGame;
import ee.mainor.classroom.repository.GuessingGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GuessingGameService {

    private final GuessingGameRepository guessingGameRepository;

    private Map<Integer, Integer> games = new HashMap<>();
    private Random random = new Random();

    @Transactional
    public Long createGame(GameCreateRequest gameCreateRequest) {
        GuessingGame guessingGame = new GuessingGame();
        guessingGame.setName("testName");
        guessingGame.setCorrectAnswer(gameCreateRequest.getCorrectAnswer());


        GuessingGame saved = guessingGameRepository.save(guessingGame);
        return saved.getId();
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

    public List<GameDto> getAll() {
        return guessingGameRepository.findAll()
                .stream()
                .map(game -> new GameDto().setId(game.getId())
                        .setName(game.getName())).toList();
    }

}
