package br.com.cc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name="tb_marca") 
@Getter @Setter
@NoArgsConstructor
public class Marca {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy="marca", cascade=CascadeType.ALL)
	@Setter(value=AccessLevel.NONE) 
	private List<Modelo> modelos;

	public Marca(String nome) {
		this.nome = nome;
	}
	
	public Marca(String nome, List<Modelo> modelos) {
		this.nome = nome;
		this.modelos = modelos;
	}
	
	public void setModelos(List<Modelo> modelos) {
		this.modelos = new ArrayList<Modelo>();
		for (Modelo modelo : modelos) {
			modelo.setMarca(this);
			this.modelos.add(modelo);
		}
	}










}
