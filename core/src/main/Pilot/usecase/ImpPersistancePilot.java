package usecase;

import model.Pilots;

public class ImpPersistancePilot implements PersistancePilot{
    public ImpPersistancePilot(){}

    @Override
    public boolean searchPilot(String document) {
        return false;
    }

    @Override
    public boolean savePilot(Pilots pilot) {
        return false;
    }
}
