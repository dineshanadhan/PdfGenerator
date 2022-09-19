package com.example.pdfgenerator.repository;

import com.example.pdfgenerator.model.KeyValuePair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KvpRepository extends JpaRepository<String, String> {

}

