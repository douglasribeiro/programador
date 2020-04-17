package com.example.programador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.programador.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
