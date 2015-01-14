package br.com.cc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import lombok.Getter;
import br.com.cc.entity.Marca;
import br.com.cc.persistence.JpaUtil;

@ViewScoped
@ManagedBean
@Getter
public class MarcaBean {

	private List<Marca> marcas;

	private List<Marca> marcasParaIncluir = new ArrayList<Marca>();
	
	private Marca novaMarca = new Marca();

	public void addMarca() {
		marcasParaIncluir.add(novaMarca);
		this.novaMarca = new Marca();
	}

	@PostConstruct
	public void carregaMarcas() {
		EntityManager em = JpaUtil.getEntityManager();
		marcas = em.createQuery("select marca from Marca marca join fetch marca.modelos", Marca.class).getResultList();
		em.close();
	}
}
