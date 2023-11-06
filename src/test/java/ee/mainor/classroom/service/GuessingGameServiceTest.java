package ee.mainor.classroom.service;

import ee.mainor.classroom.dto.GameCreateRequest;
import ee.mainor.classroom.model.GuessingGame;
import ee.mainor.classroom.repository.GuessingGameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GuessingGameServiceTest {


    @Mock
    private GuessingGameRepository guessingGameRepository;

    @InjectMocks
    private GuessingGameService guessingGameService;

    @Test
    public void createGame() {
        when(guessingGameRepository.save(any())).thenReturn(new GuessingGame().setId(1L));

        Long result =  guessingGameService.createGame(new GameCreateRequest());

        assertThat(result).isEqualTo(1L);
    }

}