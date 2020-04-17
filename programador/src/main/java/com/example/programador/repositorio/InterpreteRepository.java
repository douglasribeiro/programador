package com.example.programador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.programador.entities.Interprete;

@Repository
public interface InterpreteRepository extends JpaRepository<Interprete, Long> {

}
