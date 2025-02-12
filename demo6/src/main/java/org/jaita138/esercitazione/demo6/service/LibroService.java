package org.jaita138.esercitazione.demo6.service;

import java.util.List;

import org.jaita138.esercitazione.demo6.db.entity.Libro;
import org.jaita138.esercitazione.demo6.db.repo.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List <Libro> findAll() {
        return libroRepo.findAll();
    }

    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }
    
    public List<Libro> findAllWithAutore() {
        
        return libroRepo.findAllWithAutore();
    }

    public List<Libro> findAllWithAutoreAndGenere() {
        
        return libroRepo.findAllWithAutoreAndGenere();
    }
    

}
