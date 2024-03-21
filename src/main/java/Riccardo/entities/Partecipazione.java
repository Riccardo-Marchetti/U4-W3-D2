package Riccardo.entities;

import Riccardo.enums.Stato;
import jakarta.persistence.*;

@Entity
@Table (name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Stato stato;
    // MANYTOONE CON PERSONA
    @ManyToOne
    @JoinColumn (name = "persona_id")
    private Persona persona;
    // MANYTOONE CON EVENTO
    @ManyToOne
    @JoinColumn (name = "evento_id")
    private Evento evento;

    public Partecipazione(Stato stato, Persona persona, Evento evento) {
        this.stato = stato;
        this.persona = persona;
        this.evento = evento;
    }

    public Partecipazione(){

    }

    public long getId() {
        return id;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", stato=" + stato +
                ", persona=" + persona +
                ", evento=" + evento +
                '}';
    }
}
