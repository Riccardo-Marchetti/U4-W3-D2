package Riccardo.entities;

import Riccardo.enums.Genere;
import Riccardo.enums.TipoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;

    public Concerto(){

    }
    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, long numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
}
