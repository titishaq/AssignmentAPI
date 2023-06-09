package com.example.samplecrudapi.apicrud.listener;

import com.example.samplecrudapi.apicrud.entity.LangEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class SysLangListener {

    @PrePersist
    public void prePersist(LangEntity langEntity) {
        langEntity.setModifiedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(LangEntity langEntity) {
        langEntity.setModifiedAt(LocalDateTime.now());
    }
}

