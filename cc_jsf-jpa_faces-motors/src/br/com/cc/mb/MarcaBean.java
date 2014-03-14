package br.com.cc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import lombok.Getter;
import br.com.cc.entity.Marca;
import br.com.cc.persistence.JpaUtil;

@ManagedBean
@Getter
public class MarcaBean {

	private List<Marca> marcas;

	@PostConstruct
	public void carregaMarcas() {
		EntityManager em = JpaUtil.getEntityManager();
		marcas = em.createQuery("select marca from Marca marca join fetch marca.modelos", Marca.class).getResultList();
		em.close();
	}
}
