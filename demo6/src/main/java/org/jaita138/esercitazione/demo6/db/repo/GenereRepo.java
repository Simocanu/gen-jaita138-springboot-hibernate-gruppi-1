package org.jaita138.esercitazione.demo6.db.repo;

import org.jaita138.esercitazione.demo6.db.entity.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenereRepo extends JpaRepository<Genere, Long>{

}
