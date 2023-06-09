package com.example.samplecrudapi.apicrud.repo;

import com.example.samplecrudapi.apicrud.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<MenuEntity, String> {
}
