package com.example.samplecrudapi.apicrud.repo;

import com.example.samplecrudapi.apicrud.entity.I18NKey;
import com.example.samplecrudapi.apicrud.entity.MenuI18NEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuI18NRepo extends JpaRepository<MenuI18NEntity, I18NKey> {
}
