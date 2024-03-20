package Riccardo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "location")
public class Location {

    @Id
    @GeneratedValue
    private long id;

    private String nome;

    private String citta;
    // ONETOMANY CON EVENTO
    @OneToMany (mappedBy = "location")
    private List<Evento> evento = new ArrayList<>();

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public Location(){

    }
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
