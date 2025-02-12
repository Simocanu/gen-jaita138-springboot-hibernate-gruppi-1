package org.jaita138.esercitazione.demo6.service;

import java.util.List;

import org.jaita138.esercitazione.demo6.db.entity.Genere;
import org.jaita138.esercitazione.demo6.db.repo.GenereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenereService {

    @Autowired
    private GenereRepo genereRepo;

    public void save(Genere genere) {

        genereRepo.save(genere);
    }

    public void delete(Genere genere) {

        genereRepo.delete(genere);
    }

    public List<Genere> findAll() {

        return genereRepo.findAll();
    }
    public Genere findById(Long id) {

        return genereRepo.findById(id).orElse(null);
    }

}
