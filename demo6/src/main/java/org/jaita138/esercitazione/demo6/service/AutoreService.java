package org.jaita138.esercitazione.demo6.service;

import java.util.List;

import org.jaita138.esercitazione.demo6.db.entity.Autore;
import org.jaita138.esercitazione.demo6.db.repo.AutoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepo autoreRepo;

    public void save(Autore autore) {
        autoreRepo.save(autore);
    }

    public void delete(Autore autore) {
        autoreRepo.delete(autore);
    }

    public List<Autore> findAll() {
        return autoreRepo.findAll();
    }

    public Autore findById(Long id) {
        return autoreRepo.findById(id).orElse(null);
    }
}
