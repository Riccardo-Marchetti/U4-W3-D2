package Riccardo.entities;


import Riccardo.Exception.NotFoundException;
import Riccardo.dao.*;
import Riccardo.enums.Genere;
import Riccardo.enums.Sesso;
import Riccardo.enums.Stato;
import Riccardo.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Application {
       private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);
        LocationDao ld = new LocationDao(em);
        PartecipazioneDAO pd = new PartecipazioneDAO(em);
        PersonaDao ped = new PersonaDao(em);

//                try {
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
//        Persona persona1 = new Persona("Aldo", "Rossi", "aldorossi@gmail.com", LocalDate.of(1980, 4 , 23), Sesso.M);
//        Persona persona2 = new Persona("Anna", "Bianchi", "annabianchi@gmail.com", LocalDate.of(1990, 7 , 12), Sesso.F);
//
//        ped.save(persona1);
//        ped.save(persona2);
//
//        Location location1 = new Location("Location1", "Bergamo");
//        Location location2 = new Location("Location2", "Milano");
//        Location location3 = new Location("Location3", "Roma");
//        Location location4 = new Location("Location4", "Bari");
//        Location location5 = new Location("Location5", "Torino");
//        Location location6 = new Location("Location6", "Napoli");
//        Location location7 = new Location("Location7", "Milano");
//        Location location8 = new Location("Location8", "Padova");
//
//        ld.save(location1);
//        ld.save(location2);
//        ld.save(location3);
//        ld.save(location4);
//        ld.save(location5);
//        ld.save(location6);
//        ld.save(location7);
//        ld.save(location8);
        
//                CREAZIONE EVENTI
//        Evento evento1 = new Evento("evento1", LocalDate.of(2024, 3, 25), "ottimo", TipoEvento.PRIVATO,14, location7);
//        Evento evento2 = new Evento("evento2", LocalDate.of(2024, 4, 10), "magnifico", TipoEvento.PUBBLICO,87, location8);
//
//
//        ed.save(evento1);
//        ed.save(evento2);
//
//        Partecipazione partecipazione1 = new Partecipazione(Stato.CONFERMATA, persona1, evento1);
//        Partecipazione partecipazione2 = new Partecipazione(Stato.CONFERMATA, persona2, evento2);
//
//        pd.save(partecipazione1);
//        pd.save(partecipazione2);
//
//        Set<Persona> atleti = new HashSet<>();
//        atleti.add(persona1);
//        atleti.add(persona2);
//
//        GaraDiAtletica gara1 = new GaraDiAtletica("Gara1", LocalDate.of(2024, 3, 7), "bello!", TipoEvento.PRIVATO,21, location1, atleti, persona1);
//        GaraDiAtletica gara2 = new GaraDiAtletica("Gara2", LocalDate.of(2024, 3, 5), "wow!", TipoEvento.PUBBLICO,56, location2, atleti, persona2);
//
//        ed.save(gara1);
//        ed.save(gara2);
//
//        PartitaDiCalcio partita1 = new PartitaDiCalcio("Milan - Inter", LocalDate.of(2024, 4, 10), "Fantastico", TipoEvento.PUBBLICO,78, location3,"Milan", "Inter", "Inter", 2, 4);
//        PartitaDiCalcio partita2 = new PartitaDiCalcio("Atalanta - Roma", LocalDate.of(2024, 6, 3), "ottimo", TipoEvento.PUBBLICO,23, location4,"Roma", "Atalanta", "Atalanta", 1, 2);
//
//        ed.save(partita1);
//        ed.save(partita2);
//
//        Concerto concerto1 = new Concerto("Concerto Dua LIpa", LocalDate.of(2024, 6, 4), "bellissimo", TipoEvento.PRIVATO,34, location5,Genere.POP, true);
//        Concerto concerto2 = new Concerto("Concerto ACDC", LocalDate.of(2024, 8, 6), "magnifico", TipoEvento.PUBBLICO,65, location6, Genere.ROCK, false);
//
//        ed.save(concerto1);
//        ed.save(concerto2);

        ed.getConcertiInStreaming(false).forEach(System.out::println);
        ed.getConcertiPerGenere(Genere.POP).forEach(System.out::println);
        ed.getPartiteVinteInCasa().forEach(System.out::println);
        ed.getPartiteVinteInTrasferta().forEach(System.out::println);

        em.close();
        emf.close();
    }
}
