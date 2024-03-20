package Riccardo.dao;

import Riccardo.Exception.NotFoundException;
import Riccardo.entities.Evento;
import Riccardo.entities.Location;
import Riccardo.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(partecipazione);

        transaction.commit();
        System.out.println("Partecipazione: " + partecipazione + " salvata correttamente");
    }
    public Evento getById(long partecipazioneId){
        Evento evento = em.find(Evento.class, partecipazioneId);
        if (evento == null) throw new NotFoundException(partecipazioneId);
        return evento;
    }
    public void delete(long partecipazioneId){
        Evento found = this.getById(partecipazioneId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(found);
        transaction.commit();
        System.out.println("Partecipazione: " + found.getId() + " eliminata correttamente");
    }
}
