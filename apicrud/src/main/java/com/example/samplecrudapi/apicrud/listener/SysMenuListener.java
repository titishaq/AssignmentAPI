package com.example.samplecrudapi.apicrud.listener;

import com.example.samplecrudapi.apicrud.entity.MenuEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class SysMenuListener {
    @PrePersist
    public void prePersist(MenuEntity menuEntity) {
        menuEntity.setModifiedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(MenuEntity menuEntity) {
        menuEntity.setModifiedAt(LocalDateTime.now());
    }
}
