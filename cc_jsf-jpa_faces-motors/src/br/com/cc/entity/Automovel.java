package br.com.cc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name="tb_automovel")
@Getter @Setter
@NoArgsConstructor
public class Automovel {
	
	@Id
	@GeneratedValue
	private Long id;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private Double preco;
	private String observacoes;
	private Long kilometragem;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_modelo", foreignKey=@ForeignKey(name="ck_automovel_modelo"))
	private Modelo modelo;

	public Automovel(Integer anoFabricacao, Integer anoModelo, Double preco, String observacoes, Long kilometragem, Modelo modelo) {
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.preco = preco;
		this.observacoes = observacoes;
		this.kilometragem = kilometragem;
		this.modelo = modelo;
	}
	
}
