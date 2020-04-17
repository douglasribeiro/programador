package com.example.programador.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.programador.entities.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long>{

}
