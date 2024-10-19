package model;

import exception.PilotException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;
public class TestModel {
    @Test
    public void UploadPilot_FailAge(){
        PilotException exception = Assertions.assertThrows(PilotException.class, () -> Pilots.factory(UUID.randomUUID(), "Franco Colapinto", "123456ABC", LocalDate.of(2020,1,1)));
        Assertions.assertEquals("El piloto no puede ser menor de 18 años", exception.getMessage());
    }
    @Test
    public void UploadPilot_FailName(){
        PilotException exception = Assertions.assertThrows(PilotException.class, () -> Pilots.factory(UUID.randomUUID(), null, "123456ABC", LocalDate.of(2000,1,1)));
        Assertions.assertEquals("Nombre Invalido", exception.getMessage());

        PilotException exception2 = Assertions.assertThrows(PilotException.class, () -> Pilots.factory(UUID.randomUUID(), "  ", "123456ABC", LocalDate.of(2000,1,1)));
        Assertions.assertEquals("Nombre Invalido", exception2.getMessage());
    }
    @Test
    public void UploadPilot_FailDocument(){
        PilotException exception = Assertions.assertThrows(PilotException.class, () -> Pilots.factory(UUID.randomUUID(), "Franco Colapinto", "   ", LocalDate.of(2000,1,1)));
        Assertions.assertEquals("Documento Invalido", exception.getMessage());

        PilotException exception2 = Assertions.assertThrows(PilotException.class, () -> Pilots.factory(UUID.randomUUID(), "Franco Colapinto", null, LocalDate.of(2000,1,1)));
        Assertions.assertEquals("Documento Invalido", exception2.getMessage());
    }
    @Test
    public void UploadPilot_FailId(){
        PilotException exception = Assertions.assertThrows(PilotException.class, () -> Pilots.factory(null, "Franco Colapinto", "123456ABC", LocalDate.of(2000,1,1)));
        Assertions.assertEquals("id Invalido", exception.getMessage());
    }
    @Test
    public void UploadPilot_FailBornDate(){
        PilotException exception = Assertions.assertThrows(PilotException.class, () -> Pilots.factory(UUID.randomUUID(), "Franco Colapinto", "123456ABC", null));
        Assertions.assertEquals("Fecha valida", exception.getMessage());
    }
}
