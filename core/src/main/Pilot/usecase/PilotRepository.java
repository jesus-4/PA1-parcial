package usecase;

import java.time.LocalDate;
import java.util.UUID;

public interface PilotRepository {
    public String registerPilot(UUID id, String name, String Document, LocalDate fechaNac);
}
