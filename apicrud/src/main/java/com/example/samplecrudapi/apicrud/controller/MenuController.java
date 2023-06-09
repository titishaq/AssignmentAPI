package com.example.samplecrudapi.apicrud.controller;

import com.example.samplecrudapi.apicrud.entity.MenuEntity;
import com.example.samplecrudapi.apicrud.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuRepo menuRepo;

    //POST
    @PostMapping
    public ResponseEntity<MenuEntity> createMenu(@RequestBody MenuEntity Menu) {
        MenuEntity createdMenu = menuRepo.save(Menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    //GET all
    @GetMapping
    public ResponseEntity<List<MenuEntity>> getAllMenus() {
        List<MenuEntity> menus = menuRepo.findAll();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    //GET by ID
    @GetMapping("{id}")
    public ResponseEntity<MenuEntity> getMenuById(@PathVariable String id) {
        MenuEntity menu = menuRepo.findById(id).orElse(null);
        if (menu != null) {
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<MenuEntity> updateMenu(@PathVariable String id,
                                                     @RequestBody MenuEntity updatedMenu) {
        MenuEntity menu = menuRepo.findById(id).orElse(null);
        if (menu != null) {
            updatedMenu.setMenuCode(id);
            updatedMenu = menuRepo.save(updatedMenu);
            return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMenu(@PathVariable String id) {
        MenuEntity menu = menuRepo.findById(id).orElse(null);
        if (menu != null) {
            menuRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}