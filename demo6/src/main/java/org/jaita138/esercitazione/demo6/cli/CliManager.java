package org.jaita138.esercitazione.demo6.cli;

import java.util.List;
import java.util.Scanner;

import org.jaita138.esercitazione.demo6.db.entity.Libro;
import org.jaita138.esercitazione.demo6.db.entity.Autore;
import org.jaita138.esercitazione.demo6.db.entity.Genere;
import org.jaita138.esercitazione.demo6.service.AutoreService;
import org.jaita138.esercitazione.demo6.service.GenereService;
import org.jaita138.esercitazione.demo6.service.LibroService;

public class CliManager {

    private Scanner scanner;

    private AutoreService autoreService;
    private LibroService libroService;
    private GenereService genereService;

    public CliManager(
            AutoreService autoreService,
            LibroService libroService,
            GenereService genereService) {
        this.autoreService = autoreService;
        this.libroService = libroService;
        this.genereService = genereService;

        scanner = new Scanner(System.in);

        stampaOpzioni();
    }

    private void separatore() {
        System.out.println("-------------------------------------------------");
    }

    private void stampaOpzioni() {

        System.out.println("Operazioni:");
        System.out.println("1. Visualizza tutti i libri");
        System.out.println("2. Visualizza libro con autore");
        System.out.println("3. Visualizza libri con autore e generi");
        System.out.println("4. Visualizza autori");
        System.out.println("5. Visualizza tutti i generi");
        System.out.println("6. Aggiungi un nuovo autore");
        System.out.println("7. Aggiungi un nuovo genere");
        System.out.println("8. Aggiungi un nuovo libro con autore e generi");
        System.out.println("9. Trova libri con titolo che inizia con 'p'");
        System.out.println("10. Trova libri con anno di pubblicazione tra 2000 e 2020");
        System.out.println("11. Trova libro con isbn 9783161484100");
        String strUserValue = scanner.nextLine();
        int userValue = Integer.parseInt(strUserValue);

        switch (userValue) {

            case 1:
                stampaLibri();
                break;
            case 2:
                stampaLibriConAutore();
                break;
            case 3:
                stampaLibriConAutoreEGenere();
                break;
            case 4:
                stampaAutori();
                break;
            case 5:
                stampaGeneri();
            case 6:
                aggiungiAutore();
                break;
            case 7:
                aggiungiGenere();
                break;
            case 8:
                // aggiungiLibroConAutoreEGenere();
                break;
            case 9:
                trovaTitoloConP();
                break;
            case 10:
                trovaTra2000E2020();
                break;
            case 11:
                libroConIsbn9783161484100();
                break;
            default:
                System.out.println("Scelta non valida!");
            

        }

        stampaOpzioni();
    }

    private void stampaLibri() {
        List<Libro> libri = libroService.findAll();
        System.out.println("\nLibri: ");
        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println("");
        }
        separatore();
    }

    private void stampaLibriConAutore() {
        List<Libro> libri = libroService.findAllAutore();
        System.out.println("\nLibri con autore: ");
        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println(libro.getAutore());
            System.out.println("");
        }
        separatore();
    }

    private void stampaLibriConAutoreEGenere() {
        List<Libro> libri = libroService.findAllAutoreAndGenere();
        System.out.println("\nLibri con autore e generi: ");
        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println(libro.getAutore());
            System.out.println(libro.getGeneri());
            System.out.println("");
        }
    }

    private void stampaAutori() {
        List<Autore> autori = autoreService.findAll();
        System.out.println("\nAutori: ");
        for (Autore autore : autori) {
            System.out.println(autore);
            System.out.println("");

        }
    }

    private void stampaGeneri() {
        List<Genere> generi = genereService.findAll();
        System.out.println("\nGeneri: ");
        for (Genere genere : generi) {
            System.out.println(genere);
            System.out.println("");

        }
    }

    private void aggiungiAutore() {
        System.out.println("\nAggiungi un nuovo autore:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cognome: ");
        String cognome = scanner.nextLine();

        System.out.print("Nazionalità: ");
        String nazionalita = scanner.nextLine();

        Autore autore = new Autore();
        autore.setNome(nome);
        autore.setCognome(cognome);
        autore.setNazionalita(nazionalita);

        autoreService.save(autore);

        System.out.println("Autore aggiunto con successo!");
        separatore();
    }

    private void aggiungiGenere() {
        System.out.println("\nAggiungi un nuovo genere:");

        System.out.print("Nome del genere: ");
        String nome = scanner.nextLine();

        Genere genere = new Genere();
        genere.setNome(nome);

        genereService.save(genere);

        System.out.println("Genere aggiunto con successo!");
        separatore();
    }

    private void trovaTitoloConP() {
        List<Libro> libri = libroService.findByTitoloStartingWith();
        System.out.println("\nLibri con titolo che inizia con 'p': ");
        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println("");
        }
 
   }
   private void trovaTra2000E2020() {
        List<Libro> libri = libroService.findByAnnoPubblicazioneBetween();
        System.out.println("\nLibri con anno di pubblicazione tra 2000 e 2020: ");
        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println("");
        }
   }
   private void libroConIsbn9783161484100() {
        List<Libro> libri = libroService.findByIsbnIgnoreCase("9783161484100");
        System.out.println("\nLibri con isbn 9783161484100: ");
        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println("");
        }
   }
}