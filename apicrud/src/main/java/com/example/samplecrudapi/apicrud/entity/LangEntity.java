package com.example.samplecrudapi.apicrud.entity;

import com.example.samplecrudapi.apicrud.listener.SysLangListener;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sys_language")
@EntityListeners(SysLangListener.class)
public class LangEntity {

    @Id
    @Column(name ="LanguageCode", length = 31, nullable = false)
    private String LanguageCode;

    @Column(nullable = false)
    private String LanguageName;

    @Column(length = 1600)
    private String LanguageDesc;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Column(length = 36, nullable = false)
    private String modifiedBy;


    public String getLanguageCode() {
        return LanguageCode;
    }

    public void setLanguageCode(String languageCode) {
        LanguageCode = languageCode;
    }

    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String languageName) {
        LanguageName = languageName;
    }

    public String getLanguageDesc() {
        return LanguageDesc;
    }

    public void setLanguageDesc(String languageDesc) {
        LanguageDesc = languageDesc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}