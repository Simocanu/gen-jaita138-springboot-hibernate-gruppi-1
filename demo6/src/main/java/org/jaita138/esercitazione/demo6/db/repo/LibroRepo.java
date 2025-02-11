package org.jaita138.esercitazione.demo6.db.repo;

import org.jaita138.esercitazione.demo6.db.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends JpaRepository <Libro, Long>{


}
