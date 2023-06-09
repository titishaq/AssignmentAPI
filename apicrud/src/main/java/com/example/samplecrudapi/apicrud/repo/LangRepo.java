package com.example.samplecrudapi.apicrud.repo;

import com.example.samplecrudapi.apicrud.entity.LangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepo extends JpaRepository<LangEntity, String> {
}
