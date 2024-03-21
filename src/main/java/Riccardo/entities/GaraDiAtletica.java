package Riccardo.entities;

import Riccardo.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento{
    @ManyToMany
    @JoinTable(name = "GaraDiAtletica_Persona",
    joinColumns = @JoinColumn (name = "garaDiAtletica_id"),
    inverseJoinColumns = @JoinColumn (name = "persona_id")
    )
    private Set<Persona> atleti ;
    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, long numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica(){

    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
