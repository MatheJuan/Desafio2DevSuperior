package com.devlpjruan.Desafio2Devsup.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bloco")
public class Bloco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant inicio;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant fim;
	
	/*@ManyToOne
	@JoinColumn(name="bloco_id")
	private Atividade atividade;*/
	
	@OneToMany(mappedBy = "blocos")
	private List<Atividade> atividades = new ArrayList<>();
	
	
	public Bloco() {
	}
	public Bloco(int id, Instant inicio, Instant fim) {
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Instant getInicio() {
		return inicio;
	}
	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}
	public Instant getFim() {
		return fim;
	}
	public void setFim(Instant fim) {
		this.fim = fim;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

	public List<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloco other = (Bloco) obj;
		return id == other.id;
	}
	
}
