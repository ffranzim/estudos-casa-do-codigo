package br.com.cc.principal;


public class PersistidorDeAutomovel2 {

	public static void main(String[] args) {
		System.out.println("CRTL + F11");
	
	}
				
//		EntityManager em = JPAUtil.getEntityManager();
////		incluirAutomovel(em);
//		listarAutomovel(em);
////		excluirAutomovel(em);
//
//		em.close();
//	}
//
//	private static void excluirAutomovel(EntityManager em) {
//		EntityTransaction tx = em.getTransaction();
//		Automovel auto = em.getReference(Automovel.class, 4L);
//		tx.begin();
//		em.remove(auto);
//		tx.commit();
//		
//	}
//
//	private static void listarAutomovel(EntityManager em) {
//		String sql = "select a from br.com.cc.entity.Automovel a";
//		System.out.println("Query: " + sql);
//		Query q = em.createQuery(sql, Automovel.class);
//		@SuppressWarnings("unchecked")
//		List<Automovel> autos = q.getResultList();
//		
//		for(Automovel a : autos) {
//			System.out.println(a.getModelo());
//		}
//	}
//
//	private static void incluirAutomovel(EntityManager em) {
//		Automovel auto = new Automovel();
//		auto.setAnoFabricacao(2000);
//		auto.setModelo("Uno");
//		auto.setObservacoes("Velho");
//		
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.persist(auto);
//		tx.commit();
//	}

}
