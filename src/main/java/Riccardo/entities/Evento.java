package Riccardo.entities;

import Riccardo.enums.TipoEvento;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "evento")
@NamedQuery(name = "getConcertiInStreaming", query = "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming")
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa > p.numeroGolSquadraOspite")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa < p.numeroGolSquadraOspite")
public class Evento {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "titolo")
    private String titolo;
    @Column (name = "dataevento")
    private LocalDate dataEvento;
    @Column (name = "descrizione")
    private String descrizione;
    @Column (name = "tipoevento")
    @Enumerated (EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column (name = "numeromassimopartecipanti")
    private long numeroMassimoPartecipanti;
    // MANYTOONE CON LOCATION
    @ManyToOne
    @JoinColumn (name = "Location_id")
    private Location location;
    // ONETOMANY CON PARTECIPAZIONE
    @OneToMany (mappedBy = "evento")
    private List<Partecipazione> partecipazione = new ArrayList<>();


    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, long numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }
    public Evento(){

    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazione() {
        return partecipazione;
    }

    public void setPartecipazione(List<Partecipazione> partecipazione) {
        this.partecipazione = partecipazione;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public long getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                ", partecipazione=" + partecipazione +
                '}';
    }
}
