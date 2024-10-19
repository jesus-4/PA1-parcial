package usecase;

import exception.PilotException;
import input.ImpPilotRepository;
import model.Pilots;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestUseCase {

    @Mock PersistancePilot persistance;
    ImpPilotRepository impPilotRepository;

    @BeforeEach
    void setUp() {
        impPilotRepository = new ImpPilotRepository(persistance);
    }

    @Test
    public void UploadPilot_Assert(){
        when(persistance.searchPilot("123456ABC")).thenReturn(false);
        String esperado = impPilotRepository.registerPilot(UUID.randomUUID(), "Fanco Colapinto", "123456ABC", LocalDate.of(2004,1,1));
        Assertions.assertEquals("123456ABC", esperado);
        verify(persistance, times(1)).searchPilot(esperado);
    }

    @Test
    public void UpLoadPilot_Fail(){
        when(persistance.searchPilot("123456ABC")).thenReturn(true);
        PilotException ex = Assertions.assertThrows(PilotException.class, () -> impPilotRepository.registerPilot(UUID.randomUUID(), "Fanco Colapinto", "123456ABC", LocalDate.of(2004, 1, 1)));
        Assertions.assertEquals("Ya existe piloto cargado con ese documento", ex.getMessage());
    }
}
