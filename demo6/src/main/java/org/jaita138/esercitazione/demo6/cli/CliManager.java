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

        String strUserValue = scanner.nextLine();
        int userValue = Integer.parseInt(strUserValue);

        switch (userValue) {

            case 1:
                stampaLibri();
                break;
            case 2:

        }

        stampaOpzioni();
    }

    private void stampaLibri() {
        List<Libro> libri = libroService.findAll();
        System.out.println("\nLibri: ");
        System.out.println(libri);
        System.out.println("");
        separatore();
    }

}
