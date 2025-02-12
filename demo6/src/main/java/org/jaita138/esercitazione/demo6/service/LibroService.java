package org.jaita138.esercitazione.demo6.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.jaita138.esercitazione.demo6.db.entity.Libro;
import org.jaita138.esercitazione.demo6.db.repo.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LibroService {

    @Autowired
    public LibroRepo libroRepo;

    public void save(Libro libro) {
        libroRepo.save(libro);
    }

    public void delete(Libro libro) {
        libroRepo.delete(libro);
    }

    public List<Libro> findAll() {
        return libroRepo.findAll();
    }

    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    @Transactional
    public List<Libro> findAllAutore() {
        List<Libro> libri = libroRepo.findAll();
        for (Libro libro : libri) {
            Hibernate.initialize(libro.getAutore());
        }
        return libri;
    }

    @Transactional
    public List<Libro> findAllAutoreAndGenere() {
        List<Libro> libri = libroRepo.findAll();
        for (Libro libro : libri) {
            Hibernate.initialize(libro.getAutore());
            Hibernate.initialize(libro.getGeneri());
        }
        return libri;
    }

}