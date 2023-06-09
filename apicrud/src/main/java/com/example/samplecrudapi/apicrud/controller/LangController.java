package com.example.samplecrudapi.apicrud.controller;

import com.example.samplecrudapi.apicrud.entity.LangEntity;
import com.example.samplecrudapi.apicrud.repo.LangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LangController {

    @Autowired
    private LangRepo langRepo;

    //POST
    @PostMapping
    public ResponseEntity<LangEntity> createLanguage(@RequestBody LangEntity language) {
        LangEntity createdLanguage = langRepo.save(language);
        return new ResponseEntity<>(createdLanguage, HttpStatus.CREATED);
    }

    //GET all
    @GetMapping
    public ResponseEntity<List<LangEntity>> getAllLanguages() {
        List<LangEntity> languages = langRepo.findAll();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    //GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<LangEntity> getLanguageById(@PathVariable String id) {
        LangEntity language = langRepo.findById(id).orElse(null);
        if (language != null) {
            return new ResponseEntity<>(language, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<LangEntity> updateLanguage(@PathVariable String id,
                                                     @RequestBody LangEntity updatedLanguage) {
        LangEntity language = langRepo.findById(id).orElse(null);
        if (language != null) {
            updatedLanguage.setLanguageCode(id); //set id for new language
            updatedLanguage = langRepo.save(updatedLanguage);
            return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLanguage(@PathVariable String id) {
        LangEntity language = langRepo.findById(id).orElse(null);
        if (language != null) {
            langRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}