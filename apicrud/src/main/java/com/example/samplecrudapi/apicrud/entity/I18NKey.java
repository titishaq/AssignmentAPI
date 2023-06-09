package com.example.samplecrudapi.apicrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class I18NKey implements Serializable {

    @Column(name= "LanguageCode")
    private String languageCode;
    @Column(name="MenuID")
    private String menuID;

    public I18NKey(String languageCode, String menuID) {
        this.languageCode = languageCode;
        this.menuID = menuID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        I18NKey i18NKey = (I18NKey) o;
        return Objects.equals(languageCode, i18NKey.languageCode) && Objects.equals(menuID, i18NKey.menuID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageCode, menuID);
    }
}
