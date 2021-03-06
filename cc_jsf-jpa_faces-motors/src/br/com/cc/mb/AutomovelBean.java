package br.com.cc.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Getter;
import lombok.Setter;
import br.com.cc.entity.Automovel;
import br.com.cc.entity.Marca;
import br.com.cc.persistence.JpaUtil;

@ViewScoped
@ManagedBean
@Getter @Setter
public class AutomovelBean implements Serializable {

	private static final long serialVersionUID = -2250941288729735637L;

	private Automovel automovel = new Automovel();
	private List<Automovel> automoveis;
	private Marca marca;
	
	public void salva(Automovel automovel) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(automovel);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Automovel> getAutomoveis() {
		if (this.automoveis == null) {
			EntityManager em = JpaUtil.getEntityManager();
			Query q = em.createQuery("select a from Automovel a", Automovel.class);
			this.automoveis = q.getResultList();
			em.close();
		}
		return automoveis;
	}

	public void excluir(Automovel automovel) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		automovel = em.merge(automovel);
		em.remove(automovel);
		em.getTransaction().commit();
		em.close();
	}
	
	public void salvar(Automovel automovel) {
		System.out.println("Cheguei aqui");
	}
}
