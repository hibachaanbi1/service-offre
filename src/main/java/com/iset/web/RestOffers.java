package com.iset.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;

@RestController
@RequestMapping("/Offres")
public class RestOffers {

    @Autowired
    private OffreRepository offreRepository;

    @GetMapping
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }

    @GetMapping("/{uid}")
    public Offre getById(@PathVariable("uid") Long uid) {
        return offreRepository.findById(uid).orElse(null);
    }

    @PostMapping
    public Offre saveOffre(@RequestBody Offre newOffre) {
        return offreRepository.save(newOffre);
    }

    @DeleteMapping("/{id}")
    public void deleteOffre(@PathVariable("id") Long id) {
        offreRepository.deleteById(id);
    }
}
