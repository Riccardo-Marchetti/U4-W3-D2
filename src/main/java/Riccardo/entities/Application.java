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
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);

//        Evento evento1 = new Evento("evento1", new Date(2024-03-25), "ottimo", TipoEvento.PRIVATO,30);
//        Evento evento2 = new Evento("evento2", new Date(2024-04-10), "magnifico", TipoEvento.PUBBLICO,100);
//        Evento evento3 = new Evento("evento3", new Date(2024-06-20), "bello!", TipoEvento.PRIVATO,40);
//        Evento evento4 = new Evento("evento4", new Date(2024-06-3), "spettacolare", TipoEvento.PUBBLICO,80);
//
//        ed.save(evento1);
//        ed.save(evento2);
//        ed.save(evento3);
//        ed.save(evento4);

        try {
            Evento ev = ed.getById(202);
            System.out.println(ev);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ed.delete(205);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();
    }
}
