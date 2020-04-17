package com.example.programador.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "MUSICA")
@Entity
public class Musica implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(length = 100)
	private String nome;
	
	private Time tempo;
	
	private Time intro;
	
	@Column(length = 4)
	private String anoLancamento;
	
	@OneToMany(targetEntity = Interprete.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "mi_fk", referencedColumnName = "id")
	private List<Interprete> interpretes;
	
	@OneToMany(targetEntity = Album.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_fk", referencedColumnName = "id")
	private List<Album> albuns;

	public List<Interprete> getInterpretes() {
		return interpretes;
	}
 
	public void setInterpretes(List<Interprete> interpretes) {
		this.interpretes = interpretes;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getTempo() {
		return tempo;
	}

	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}

	public Time getIntro() {
		return intro;
	}

	public void setIntro(Time intro) {
		this.intro = intro;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	
	
}
