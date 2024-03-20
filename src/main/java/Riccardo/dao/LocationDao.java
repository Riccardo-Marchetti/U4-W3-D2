package Riccardo.dao;

import Riccardo.Exception.NotFoundException;
import Riccardo.entities.Evento;
import Riccardo.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDao {
    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(location);

        transaction.commit();
        System.out.println("Location: " + location + " salvata correttamente");
    }
    public Evento getById(long locationId){
        Evento evento = em.find(Evento.class, locationId);
        if (evento == null) throw new NotFoundException(locationId);
        return evento;
    }
    public void delete(long locationId){
        Evento found = this.getById(locationId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(found);
        transaction.commit();
        System.out.println("Location: " + found.getId() + " eliminata correttamente");
    }
}
