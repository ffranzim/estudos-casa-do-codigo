package br.com.cc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import lombok.Getter;
import br.com.cc.entity.Marca;
import br.com.cc.persistence.JPAUtil;

@ManagedBean
@Getter
public class MarcaBean {

	private List<Marca> marcas;

	@PostConstruct
	public void carregaMarcas() {
		EntityManager em = JPAUtil.getEntityManager();
		marcas = em.createQuery("select m from Marca m", Marca.class).getResultList();
		em.close();
	}
}
