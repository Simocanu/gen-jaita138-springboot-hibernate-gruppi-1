package org.jaita138.esercitazione.demo6.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String titolo;

    @Column(length = 64)
    private String isbn;

    private int annoPubblicazione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

   
    @Override
    public String toString() {
        return "Libro [\n"
                + "  id=" + id + ",\n"
                + "  titolo=" + titolo + ",\n"
                + "  isbn=" + isbn + ",\n"
                + "  anno pubblicazione=" + annoPubblicazione + "\n"
                + "]";
    }









}
