package com.devlpjruan.Desafio2Devsup.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	@ManyToMany
	@JoinTable(name= "tb_atividade_participante",
				joinColumns = @JoinColumn(name="atividade_id"),
				inverseJoinColumns = @JoinColumn(name="participante_id"))
	private Set<Participante> participante= new HashSet<>();
	
	/*@OneToMany(mappedBy = "atividade")
	private List<Bloco> blocos = new ArrayList<>();*/
	@ManyToOne
	@JoinColumn(name="bloco_id")
	private Bloco blocos;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	public Atividade() {
	}
	public Atividade(int id, String nome, String descricao, double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Set<Participante> getParticipante() {
		return participante;
	}
 
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return id == other.id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setParticipante(Set<Participante> participante) {
		this.participante = participante;
	}
	public Bloco getBlocos() {
		return blocos;
	}
	public void setBlocos(Bloco blocos) {
		this.blocos = blocos;
	}
	 
	
	
}
