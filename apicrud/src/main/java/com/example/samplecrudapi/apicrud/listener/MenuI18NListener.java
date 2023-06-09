package com.example.samplecrudapi.apicrud.listener;

import com.example.samplecrudapi.apicrud.entity.MenuI18NEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class MenuI18NListener {

    @PrePersist
    public void prePersist(MenuI18NEntity menuI18NEntity) {
        menuI18NEntity.setModifiedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(MenuI18NEntity menuI18NEntity) {
        menuI18NEntity.setModifiedAt(LocalDateTime.now());
    }
}

