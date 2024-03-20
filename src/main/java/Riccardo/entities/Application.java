package Riccardo.entities;


import Riccardo.Exception.NotFoundException;
import Riccardo.dao.EventiDAO;
import Riccardo.dao.LocationDao;
import Riccardo.dao.PartecipazioneDAO;
import Riccardo.dao.PersonaDao;
import Riccardo.enums.Sesso;
import Riccardo.enums.Stato;
import Riccardo.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;


public class Application {
       private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);
        LocationDao ld = new LocationDao(em);
        PartecipazioneDAO pd = new PartecipazioneDAO(em);
        PersonaDao ped = new PersonaDao(em);

        //        try {
//            Evento ev = ed.getById(202);
//            System.out.println(ev);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            ed.delete(205);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        CREAZIONE PERSONA
        Persona persona1 = new Persona("Aldo", "Rossi", "aldorossi@gmail.com", LocalDate.of(1980, 4 , 23), Sesso.M);
        Persona persona2 = new Persona("Anna", "Bianchi", "annabianchi@gmail.com", LocalDate.of(1990, 7 , 12), Sesso.F);

        ped.save(persona1);
        ped.save(persona2);

        Location location1 = new Location("Location1", "Bergamo");
        Location location2 = new Location("Location2", "Milano");

        ld.save(location1);
        ld.save(location2);
        
        //        CREAZIONE EVENTI
        Evento evento1 = new Evento("evento1", LocalDate.of(2024, 3, 25), "ottimo", TipoEvento.PRIVATO,30, location1);
        Evento evento2 = new Evento("evento2", LocalDate.of(2024, 4, 10), "magnifico", TipoEvento.PUBBLICO,100, location2);


        ed.save(evento1);
        ed.save(evento2);

        Partecipazione partecipazione1 = new Partecipazione(Stato.CONFERMATA, persona1, evento1);
        Partecipazione partecipazione2 = new Partecipazione(Stato.CONFERMATA, persona2, evento2);

        pd.save(partecipazione1);
        pd.save(partecipazione2);

        em.close();
        emf.close();
    }
}
