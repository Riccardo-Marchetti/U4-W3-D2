package Riccardo.dao;

import Riccardo.Exception.NotFoundException;
import Riccardo.entities.Evento;
import Riccardo.entities.Partecipazione;
import Riccardo.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDao {
    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(persona);

        transaction.commit();
        System.out.println("Persona: " + persona + " salvata correttamente");
    }
    public Evento getById(long personaId){
        Evento evento = em.find(Evento.class, personaId);
        if (evento == null) throw new NotFoundException(personaId);
        return evento;
    }
    public void delete(long personaId){
        Evento found = this.getById(personaId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(found);
        transaction.commit();
        System.out.println("Persona: " + found.getId() + " eliminata correttamente");
    }

}
