package Riccardo.entities;


import Riccardo.Exception.NotFoundException;
import Riccardo.dao.EventiDAO;

import Riccardo.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;


public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args){
        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);

        Evento evento1 = new Evento("evento1", new Date(2024-03-25), "Stupendo", TipoEvento.PRIVATO, 30);
        Evento evento2 = new Evento("evento2", new Date(2024-05-19), "Evento magnifico", TipoEvento.PUBBLICO, 100);

        ed.safe(evento1);
        ed.safe(evento2);

        try {
           Evento evento =  ed.getById(103);
            System.out.println(evento);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ed.delete(102);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        em.close();
        emf.close();
    }
}
