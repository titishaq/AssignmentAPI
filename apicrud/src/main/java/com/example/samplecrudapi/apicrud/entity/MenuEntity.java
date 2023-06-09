package com.example.samplecrudapi.apicrud.entity;

import com.example.samplecrudapi.apicrud.listener.SysMenuListener;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sys_menu")
@EntityListeners(SysMenuListener.class)
public class MenuEntity {

    @Id
    @Column( name = "MenuID", length = 36, nullable = false)
    private String menuID;

    @Column(length = 31, nullable = false, unique = true)
    private String menuCode;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Column(length = 36, nullable = false)
    private String modifiedBy;

    // Getters and setters

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
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