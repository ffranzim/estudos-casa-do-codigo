package br.com.cc.principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.cc.entity.Automovel;
import br.com.cc.entity.Marca;
import br.com.cc.entity.Modelo;
import br.com.cc.persistence.JPAUtil;

public class PersistidorDeAutomovel {

	public static void main(String[] args) {
				
		EntityManager em = JPAUtil.getEntityManager();
//		consultaTeste(em);
		incluirAutomovel(em);
//		listarAutomovel(em);
//		excluirAutomovel(em);

		em.close();
	}


	private static void  consultaTeste(EntityManager em) {
		String jpql = "select a from br.com.cc.entity.Automovel a where a.modelo.marca.descricao = 'Chevrolet'";
		Query q = em.createQuery(jpql, Automovel.class);
		@SuppressWarnings("unchecked")
		List<Automovel> autos = q.getResultList();
		
		for(Automovel a : autos) {
			System.out.println("Dados do automovel ");
			System.out.println("Id : " + a.getId());
			System.out.println("Ano de fabricação : " + a.getAnoFabricacao());
			System.out.println("Ano do Modelo: " + a.getAnoModelo());
			System.out.println("KM : " + a.getKilometragem());
			System.out.println("R$ : " + a.getPreco());
			System.out.println("Observações : " + a.getObservacoes());
			
			System.out.println("Dados da Modelo ");
			System.out.println("Nome modelo : " + a.getModelo().getNome());
			System.out.println("Cavalos : " + a.getModelo().getPotencia());
			
			
			System.out.println("Dados da marca ");
			System.out.println("Nome da Marca : " + a.getModelo().getMarca().getNome());

		}
		
	}
	

	private static void incluirAutomovel(EntityManager em) {
		Marca marca = new Marca("GM");
		Modelo modelo = new Modelo("Gol", 110, marca);
		Automovel automovel = new Automovel(2011, 2011, 23900.00, "Azul", 40000L, modelo);
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(automovel);
		tx.commit();
		
		
////		Automovel auto = new Automovel();
////		auto.setAnoFabricacao(2000);
////		auto.setModelo(modelo);
//		auto.setObservacoes("Velho");
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.persist(auto);
//		tx.commit();
	}
	
	
	
	
	
//	private static void excluirAutomovel(EntityManager em) {
//		EntityTransaction tx = em.getTransaction();
//		Automovel_old auto = em.getReference(Automovel_old.class, 4L);
//		tx.begin();
//		em.remove(auto);
//		tx.commit();
//		
//	}
//
//	private static void listarAutomovel(EntityManager em) {
//		String sql = "select a from Automovel a";
//		System.out.println("Query: " + sql);
//		Query q = em.createQuery(sql, Automovel.class);
//		@SuppressWarnings("unchecked")
//		List<Automovel> autos = q.getResultList();
//		
//		for(Automovel a : autos) {
//			System.out.println(a.getObservacoes());
//		}
//	}

}
