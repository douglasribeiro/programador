package com.example.programador.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Table(name = "INTERPRETE")
@Entity
public class Interprete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 80)
	@Getter @Setter
	private String nome;

	@OneToMany(targetEntity = InterpreteComentario.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ic_fk", referencedColumnName = "id")
	private List<InterpreteComentario> comentarios;

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

	public List<InterpreteComentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<InterpreteComentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
