package Riccardo.dao;


import Riccardo.Exception.NotFoundException;
import Riccardo.entities.Concerto;
import Riccardo.entities.Evento;
import Riccardo.entities.PartitaDiCalcio;
import Riccardo.enums.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class EventiDAO {

    private final EntityManager  em;

    public EventiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(evento);

        transaction.commit();
        System.out.println("Evento: " + evento + " salvato correttamente");
    }
    public Evento getById(long eventoId){
        Evento evento = em.find(Evento.class, eventoId);
        if (evento == null) throw new NotFoundException(eventoId);
        return evento;
    }
    public void delete(long eventoId){
        Evento found = this.getById(eventoId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(found);
        transaction.commit();
        System.out.println("Evento: " + found.getId() + " eliminato correttamente");
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming){
        TypedQuery<Concerto> query = em.createNamedQuery("getConcertiInStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere){
        TypedQuery <Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> query =  em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
