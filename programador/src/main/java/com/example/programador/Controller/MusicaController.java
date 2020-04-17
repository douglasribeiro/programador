package com.example.programador.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.programador.entities.Musica;
import com.example.programador.exception.ResourceNotFoundException;
import com.example.programador.repositorio.MusicaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/musica" })
public class MusicaController {
	
	@Autowired
	private MusicaRepository musicaRepository;
	  
	@GetMapping()
	public List<Musica> getAllMusicas() {
		return musicaRepository.findAll();
	}  
	 
	
	@GetMapping("/{id}")
	public ResponseEntity<Musica> getMusicaById(@PathVariable(value = "id") Long musicaId) throws ResourceNotFoundException {
		Musica musica = musicaRepository.findById(musicaId)
				.orElseThrow(() -> new ResourceNotFoundException("Este codigo não é registrado :: " + musicaId));
		return ResponseEntity.ok().body(musica);
	}
	
	@PostMapping()
	public Musica createMusica(@Valid @RequestBody Musica musica) {
		return musicaRepository.save(musica);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Musica> updateMusica(@PathVariable(value = "id") Long musicaId,
			@Valid @RequestBody Musica musicaDetails) throws ResourceNotFoundException {
		Musica musica = musicaRepository.findById(musicaId)
				.orElseThrow(() -> new ResourceNotFoundException("Este codigo não existe :: " + musicaId));

		musica.setAnoLancamento(musicaDetails.getAnoLancamento());
		musica.setIntro(musicaDetails.getIntro());
		musica.setNome(musicaDetails.getNome());
		musica.setTempo(musicaDetails.getTempo());
		
		final Musica updatedMusica = musicaRepository.save(musica);
		return ResponseEntity.ok(updatedMusica);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteMusica(@PathVariable(value = "id") Long musicaId)
			throws ResourceNotFoundException {
		Musica musica = musicaRepository.findById(musicaId)
				.orElseThrow(() -> new ResourceNotFoundException("Esta codigo não existe :: " + musicaId));

		musicaRepository.delete(musica);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
