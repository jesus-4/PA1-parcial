package usecase;

import model.Pilots;

public interface PersistancePilot {
    public boolean searchPilot(String document);
    public boolean savePilot(Pilots pilot);
}
