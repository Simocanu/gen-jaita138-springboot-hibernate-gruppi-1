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
}
