package Riccardo.dao;

import Riccardo.Exception.NotFoundException;
import Riccardo.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
private final EntityManager em;

    public EventiDAO(EntityManager em) {
        this.em = em;
    }

    public void safe(Evento evento){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(evento);

        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " salvato!");
    }

    public Evento getById(long eventoId)  {
        Evento evento = em.find(Evento.class, eventoId);
        if (evento == null) throw new NotFoundException(eventoId);
        return evento;
    }
    public void delete(long eventoId)  {

        Evento found = this.getById(eventoId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);
        transaction.commit();
        System.out.println("Evento " + found.getId() + "eliminato!");
    }
}
