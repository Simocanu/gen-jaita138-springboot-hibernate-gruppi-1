package org.jaita138.esercitazione.demo6.db.repo;

import java.util.List;

import org.jaita138.esercitazione.demo6.db.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {
    List<Libro> findByTitoloStartingWithIgnoreCase(String titolo);

    List<Libro>findByAnnoPubblicazioneBetween(Integer min, Integer max);
    
    List<Libro>findByIsbnIgnoreCase(String Isbn);
    

}