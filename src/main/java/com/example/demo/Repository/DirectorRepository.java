package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Writer;

@Repository
public interface DirectorRepository extends JpaRepository<Writer,Long> {

}