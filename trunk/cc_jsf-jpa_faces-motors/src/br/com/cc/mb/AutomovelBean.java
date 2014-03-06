package br.com.cc.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Getter;
import lombok.Setter;
import br.com.cc.entity.Automovel;
import br.com.cc.persistence.JPAUtil;

@ManagedBean
@Getter
@Setter
public class AutomovelBean {

	private Automovel automovel = new Automovel();

	private List<Automovel> automoveis;

	public void salva(Automovel automovel) {

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(automovel);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Automovel> getAutomoveis() {
		if (this.automoveis == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select a from Automoveis a", Automovel.class);
			this.automoveis = q.getResultList();
			em.close();
		}
		return automoveis;
	}

	public void excluir(Automovel automovel) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		automovel = em.merge(automovel);
		em.remove(automovel);
		em.getTransaction().commit();
		em.close();

	}
}
