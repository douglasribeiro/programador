package com.example.programador.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.programador.repositorio.AlbumRepository;

@RestController
@RequestMapping({ "/album" })
public class AlbumController {

	private AlbumRepository albumRepository;
	
	public AlbumController(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}
	
	@GetMapping public List findAll() { return albumRepository.findAll(); }
}
