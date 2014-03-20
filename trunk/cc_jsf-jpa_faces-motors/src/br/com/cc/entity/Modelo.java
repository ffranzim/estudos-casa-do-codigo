package br.com.cc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @Table(name="tb_modelo") 
@Getter @Setter
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class Modelo {
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	private Integer potencia;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_marca", foreignKey=@ForeignKey(name="ck_modelo_marca"))
	private Marca marca;

	public Modelo(String nome, Integer potencia, Marca marca) {
		this.nome = nome;
		this.potencia = potencia;
		this.marca = marca;
	}


	
}
