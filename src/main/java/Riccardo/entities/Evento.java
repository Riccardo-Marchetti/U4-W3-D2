package Riccardo.entities;

import Riccardo.enums.TipoEvento;
import jakarta.persistence.*;

import java.util.Date;

@Entity // QUESTA CLASSE DEVE ESSERE MAPPATA NELLA TABELLA
@Table (name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long id;

    @Column (name = "titolo")
    private String titolo;
    @Column (name = "dataevento")
    private Date dataEvento;
    @Column (name = "descrizione")
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column (name = "tipoevento")
    private TipoEvento tipoEvento;
    @Column (name = "numeromassimopartecipanti")
    private long numeroMassimoPartecipanti;

    public Evento() {

    }

    public Evento(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, long numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
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

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
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

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
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
                '}';
    }
}
