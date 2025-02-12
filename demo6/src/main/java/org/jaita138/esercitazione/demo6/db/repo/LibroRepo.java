package org.jaita138.esercitazione.demo6.db.repo;

import java.util.List;

import org.jaita138.esercitazione.demo6.db.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends JpaRepository <Libro, Long>{

    @Query("SELECT l FROM Libro l JOIN FETCH l.autore")
    List<Libro> findAllWithAutore(); 

    @Query("SELECT l FROM Libro l JOIN FETCH l.autore LEFT JOIN FETCH l.generi")
    List<Libro> findAllWithAutoreAndGenere();
}
