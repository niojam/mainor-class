package ee.mainor.classroom.integration;

import ee.mainor.classroom.EnableTestcontainers;
import ee.mainor.classroom.dto.GameCreateRequest;
import ee.mainor.classroom.model.GuessingGame;
import ee.mainor.classroom.service.GuessingGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@EnableTestcontainers
@SpringBootTest
public class GuessingGameServiceIntegrationTest {

    @Autowired
    private GuessingGameService guessingGameService;


    @Test
    public void findAllGames() {
        Long result =  guessingGameService.createGame(new GameCreateRequest());

        assertThat(result).isEqualTo(1L);
    }

}
