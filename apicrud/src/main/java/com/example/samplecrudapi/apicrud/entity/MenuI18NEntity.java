package com.example.samplecrudapi.apicrud.entity;


import com.example.samplecrudapi.apicrud.listener.MenuI18NListener;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Sys_Menu_I18N")
@EntityListeners(MenuI18NListener.class)
public class MenuI18NEntity {
    @EmbeddedId
    private I18NKey i18NKey;
    @ManyToOne
    @JoinColumn(name = "LanguageCode", insertable = false, updatable = false)
    private LangEntity langEntity;

    @ManyToOne
    @JoinColumn(name = "MenuID", insertable = false, updatable = false)
    private MenuEntity menuEntity;


    @Column(nullable = false)
    private String MenuName;

    @Column(length = 1600)
    private String MenuDesc;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Column(length = 36, nullable = false)
    private String modifiedBy;

    public I18NKey getI18NKey() {
        return i18NKey;
    }

    public void setI18NKey(I18NKey i18NKey) {
        this.i18NKey = i18NKey;
    }

    public LangEntity getLangEntity() {
        return langEntity;
    }

    public void setLangEntity(LangEntity langEntity) {
        this.langEntity = langEntity;
    }

    public MenuEntity getMenuEntity() {
        return menuEntity;
    }

    public void setMenuEntity(MenuEntity menuEntity) {
        this.menuEntity = menuEntity;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getMenuDesc() {
        return MenuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        MenuDesc = menuDesc;
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


