package com.example.samplecrudapi.apicrud.controller;

import com.example.samplecrudapi.apicrud.entity.I18NKey;
import com.example.samplecrudapi.apicrud.entity.LangEntity;
import com.example.samplecrudapi.apicrud.entity.MenuEntity;
import com.example.samplecrudapi.apicrud.entity.MenuI18NEntity;
import com.example.samplecrudapi.apicrud.repo.LangRepo;
import com.example.samplecrudapi.apicrud.repo.MenuI18NRepo;
import com.example.samplecrudapi.apicrud.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu-i18n")
public class MenuI18NController {
@Autowired
    private  MenuI18NRepo menuI18NRepo;
    private LangRepo langRepo;
    private MenuRepo menuRepo;

    @GetMapping("/{aid}/{bid}")
    public ResponseEntity<MenuI18NEntity> getCByIds(@PathVariable String languageCode, @PathVariable String menuId) {
        I18NKey i18NKey = new I18NKey(languageCode, menuId);
        MenuI18NEntity i18NEntity = menuI18NRepo.findById(i18NKey).orElse(null);
        if (i18NEntity != null) {
            return ResponseEntity.ok(i18NEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MenuI18NEntity> createMenuI18NEntity(@RequestBody MenuI18NEntity menuI18NEntity) {
        LangEntity langEntity = langRepo.findById(menuI18NEntity.getLangEntity().getLanguageCode()).orElse(null);
        MenuEntity menuEntity = menuRepo.findById(menuI18NEntity.getMenuEntity().getMenuID()).orElse(null);
        if (langEntity != null && menuEntity != null) {
            menuI18NEntity.setLangEntity(langEntity);
            menuI18NEntity.setMenuEntity(menuEntity);
            MenuI18NEntity savedC = menuI18NRepo.save(menuI18NEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedC);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{aid}/{bid}")
    public ResponseEntity<MenuI18NEntity> updateMenuI18NEntityByIds(@PathVariable String languageCode, @PathVariable String menuId, @RequestBody MenuI18NEntity updatedmenuI18NEntity) {
        I18NKey i18NKey = new I18NKey(languageCode, menuId);
        MenuI18NEntity existingMenuI18NEntity = menuI18NRepo.findById(i18NKey).orElse(null);
        if (existingMenuI18NEntity != null) {
            LangEntity langEntity = langRepo.findById(updatedmenuI18NEntity.getLangEntity().getLanguageCode()).orElse(null);
            MenuEntity menuEntity = menuRepo.findById(updatedmenuI18NEntity.getMenuEntity().getMenuID()).orElse(null);
            if (langEntity != null && menuEntity != null) {
                existingMenuI18NEntity.setLangEntity(langEntity);
                existingMenuI18NEntity.setMenuEntity(menuEntity);
                MenuI18NEntity updatedNebyI18EntityInstance = menuI18NRepo.save(existingMenuI18NEntity);
                return ResponseEntity.ok(updatedNebyI18EntityInstance);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{aid}/{bid}")
    public ResponseEntity<Void> deleteMenuI18NEntitybyIds(@PathVariable String languageCode, @PathVariable String menuId) {
        I18NKey i18NKey = new I18NKey(languageCode, menuId);
        MenuI18NEntity existingMenuI18NEntity = menuI18NRepo.findById(i18NKey).orElse(null);
        if (existingMenuI18NEntity != null) {
            menuI18NRepo.delete(existingMenuI18NEntity);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}