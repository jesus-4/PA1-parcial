package usecase;

import exception.PilotException;
import model.Pilots;

import java.time.LocalDate;
import java.util.UUID;

public class ImpPilotRepository implements PilotRepository {
    private final PersistancePilot persistancePilot;

    public ImpPilotRepository(PersistancePilot persistancePilot) {
        this.persistancePilot = persistancePilot;
    }

    @Override
    public String registerPilot(UUID id, String name, String document, LocalDate fechaNac) throws PilotException {
        Pilots pilot =Pilots.factory(id, name, document, fechaNac);
        if (persistancePilot.searchPilot(pilot.getDocument()))
            throw new PilotException("Ya existe piloto cargado con ese documento");

        return pilot.getDocument();
    }
}
