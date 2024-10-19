package model;

import exception.PilotException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

public class Pilots {
    private UUID id;
    private String name;
    private String document;
    private LocalDate born;
    private Pilots(UUID id, String name, String document, LocalDate born) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.born = born;
    }
    public static Pilots factory(UUID id, String name, String document, LocalDate born)throws PilotException {
        if (born == null )
            throw new PilotException("Fecha valida");

        if(LocalDate.now().getYear()-born.getYear() < 18)
            throw new PilotException("El piloto no puede ser menor de 18 años");

        if(name == null || name.isBlank())
            throw new PilotException("Nombre Invalido");

        if (id == null)
            throw new PilotException("id Invalido");

        if(document == null || document.isBlank())
            throw new PilotException("Documento Invalido");

        return new Pilots(id, name, document, born);
    }
    public String getDocument() {
        return document;
    }
}
