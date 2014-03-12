package br.com.cc.principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cc.entity.Automovel;
import br.com.cc.entity.Marca;
import br.com.cc.persistence.JPAUtil;

public class PersistidorDeAutomovel {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		// consultaTeste(em);
		// incluirAutomovel(em);
		// listarAutomovel(em);
		// excluirAutomovel(em);
		// jpqlTeste(em);
		// jpqlTestePassandoParametros(em);
		// jpqlTesteAgregacao(em);
		// jpqlTesteSubConsulta(em);
		// jpqlTesteSubConsulta2(em);
		// jpqlTesteResultadoEstranhoComNew(em);
		// jpqlTesteNamedQuery(em);
		// jpqlTesteNamedQuery2(em);
		jpqlTesteNamedQueryComParametro(em);
		em.close();
	}

	private static void jpqlTesteNamedQueryComParametro(EntityManager em) {
		Query q = em.createNamedQuery("Automovel.listarPorMarca");
		q.setParameter("marca", em.find(Marca.class, 2L));
		@SuppressWarnings("unchecked")
		List<Automovel> autos = q.getResultList();

		for (Automovel a : autos) {
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

	// private static void jpqlTesteNamedQuery2(EntityManager em) {
	// Query q = em.createNamedQuery("Automovel.listarNaoExcluidos");
	// @SuppressWarnings("unchecked")
	// List<Automovel> autos = q.getResultList();
	//
	// for (Automovel a : autos) {
	// System.out.println("Dados do automovel ");
	// System.out.println("Id : " + a.getId());
	// System.out.println("Ano de fabricação : " + a.getAnoFabricacao());
	// System.out.println("Ano do Modelo: " + a.getAnoModelo());
	// System.out.println("KM : " + a.getKilometragem());
	// System.out.println("R$ : " + a.getPreco());
	// System.out.println("Observações : " + a.getObservacoes());
	//
	// System.out.println("Dados da Modelo ");
	// System.out.println("Nome modelo : " + a.getModelo().getNome());
	// System.out.println("Cavalos : " + a.getModelo().getPotencia());
	//
	// System.out.println("Dados da marca ");
	// System.out.println("Nome da Marca : " +
	// a.getModelo().getMarca().getNome());
	//
	// }
	//
	// }

	// private static void jpqlTesteNamedQuery(EntityManager em) {
	// Query q = em.createNamedQuery("Automovel.listarTodos");
	// @SuppressWarnings("unchecked")
	// List<Automovel> autos = q.getResultList();
	//
	// for (Automovel a : autos) {
	// System.out.println("Dados do automovel ");
	// System.out.println("Id : " + a.getId());
	// System.out.println("Ano de fabricação : " + a.getAnoFabricacao());
	// System.out.println("Ano do Modelo: " + a.getAnoModelo());
	// System.out.println("KM : " + a.getKilometragem());
	// System.out.println("R$ : " + a.getPreco());
	// System.out.println("Observações : " + a.getObservacoes());
	//
	// System.out.println("Dados da Modelo ");
	// System.out.println("Nome modelo : " + a.getModelo().getNome());
	// System.out.println("Cavalos : " + a.getModelo().getPotencia());
	//
	// System.out.println("Dados da marca ");
	// System.out.println("Nome da Marca : " +
	// a.getModelo().getMarca().getNome());
	//
	// }
	// }

	// private static void jpqlTesteResultadoEstranhoComNew(EntityManager em) {
	// String jpql =
	// "select new br.com.cc.bo.ResumoAutomovel(a.modelo.marca.nome, a.modelo.nome, a.preco) from Automovel a";
	//
	// Query query = em.createQuery(jpql, ResumoAutomovel.class);
	// @SuppressWarnings("unchecked")
	// List<ResumoAutomovel> resumoAutomoveis = query.getResultList();
	// for (ResumoAutomovel resumoAutomovel : resumoAutomoveis) {
	// System.out.println("Nome Marca: " + resumoAutomovel.getNomeMarca());
	// System.out.println("Nome Modelo: " + resumoAutomovel.getNomeModelo());
	// System.out.println("Preço: " + resumoAutomovel.getPreco());
	//
	// }
	// }

	// private static void jpqlTesteResultadoEstranho(EntityManager em) {
	// String jpql =
	// "select a.modelo.marca.nome, a.modelo.nome, a.preco from Automovel a";
	//
	// Query query = em.createQuery(jpql);
	// @SuppressWarnings("unchecked")
	// List<Object[]> result = query.getResultList();
	// for (Object[] row : result) {
	// String nomeMarca = (String) row[0];
	// String nomeModelo = (String) row[1];
	// Double preco = (Double) row[2];
	//
	// System.out.println("Nome Marca: " + nomeMarca);
	// System.out.println("Nome Modelo: " + nomeModelo);
	// System.out.println("Preço: " + preco);
	//
	// }
	// }

	// private static void jpqlTesteSubConsulta2(EntityManager em) {
	// String jpql =
	// "select marca from Marca marca where EXISTS (select a from Automovel a where a.modelo.marca = marca and a.preco >= 10)";
	// Query q = em.createQuery(jpql, Marca.class);
	// @SuppressWarnings("unchecked")
	// List<Marca> marcas = q.getResultList();
	//
	// for (Marca m : marcas) {
	// System.out.println("Dados da Marca ");
	// System.out.println("Id : " + m.getId());
	// System.out.println("Marca : " + m.getNome());
	//
	// for (Modelo modelo : m.getModelos()) {
	// System.out.println("Dados da Modelo ");
	// System.out.println("Nome modelo : " + modelo.getNome());
	// System.out.println("Cavalos : " + modelo.getPotencia());
	// }
	// }
	//
	// }

	// private static void jpqlTesteSubConsulta(EntityManager em) {
	// String jpql =
	// "select a from Automovel a where a.anoModelo >= (select AVG(auto.anoModelo) from Automovel auto)";
	// Query q = em.createQuery(jpql, Automovel.class);
	// @SuppressWarnings("unchecked")
	// List<Automovel> autos = q.getResultList();
	//
	// for (Automovel a : autos) {
	// System.out.println("Dados do automovel ");
	// System.out.println("Id : " + a.getId());
	// System.out.println("Ano de fabricação : " + a.getAnoFabricacao());
	// System.out.println("Ano do Modelo: " + a.getAnoModelo());
	// System.out.println("KM : " + a.getKilometragem());
	// System.out.println("R$ : " + a.getPreco());
	// System.out.println("Observações : " + a.getObservacoes());
	//
	// System.out.println("Dados da Modelo ");
	// System.out.println("Nome modelo : " + a.getModelo().getNome());
	// System.out.println("Cavalos : " + a.getModelo().getPotencia());
	//
	// System.out.println("Dados da marca ");
	// System.out.println("Nome da Marca : " +
	// a.getModelo().getMarca().getNome());
	//
	// }
	//
	// }

	// private static void jpqlTesteAgregacao(EntityManager em) {
	// String jpql = "select MAX(a.anoModelo) from Automovel a";
	// Query q = em.createQuery(jpql, Integer.class);
	// Integer maiorAnoModelo = (Integer) q.getSingleResult();
	// System.out.println("Modelo mais novo ano : " + maiorAnoModelo);
	// }

	// private static void jpqlTestePassandoParametros(EntityManager em) {
	// String jpql =
	// "select m from Marca m join m.modelos modelo where modelo.nome like :modelo";
	// Query q = em.createQuery(jpql, Marca.class);
	// q.setParameter("modelo", "%" + "prisma" + "%");
	// @SuppressWarnings("unchecked")
	// List<Marca> marcas = q.getResultList();
	//
	// for(Marca m : marcas) {
	// System.out.println("Dados da Marca ");
	// System.out.println("Id : " + m.getId());
	// System.out.println("Marca : " + m.getNome());
	//
	// for(Modelo modelo : m.getModelos()) {
	// System.out.println("Dados da Modelo ");
	// System.out.println("Nome modelo : " + modelo.getNome());
	// System.out.println("Cavalos : " + modelo.getPotencia());
	// }
	// }
	//
	// }
	//
	// private static void jpqlTeste(EntityManager em) {
	// String jpql =
	// "select m from Marca m join m.modelos modelo where modelo.nome like '%prisma%'";
	// Query q = em.createQuery(jpql, Marca.class);
	// @SuppressWarnings("unchecked")
	// List<Marca> marcas = q.getResultList();
	//
	// for(Marca m : marcas) {
	// System.out.println("Dados da Marca ");
	// System.out.println("Id : " + m.getId());
	// System.out.println("Marca : " + m.getNome());
	//
	// for(Modelo modelo : m.getModelos()) {
	// System.out.println("Dados da Modelo ");
	// System.out.println("Nome modelo : " + modelo.getNome());
	// System.out.println("Cavalos : " + modelo.getPotencia());
	// }
	// }
	//
	// }
	//
	// private static void consultaTeste(EntityManager em) {
	// String jpql =
	// "select a from br.com.cc.entity.Automovel a where a.modelo.marca.descricao = 'Chevrolet'";
	// Query q = em.createQuery(jpql, Automovel.class);
	// @SuppressWarnings("unchecked")
	// List<Automovel> autos = q.getResultList();
	//
	// for (Automovel a : autos) {
	// System.out.println("Dados do automovel ");
	// System.out.println("Id : " + a.getId());
	// System.out.println("Ano de fabricação : " + a.getAnoFabricacao());
	// System.out.println("Ano do Modelo: " + a.getAnoModelo());
	// System.out.println("KM : " + a.getKilometragem());
	// System.out.println("R$ : " + a.getPreco());
	// System.out.println("Observações : " + a.getObservacoes());
	//
	// System.out.println("Dados da Modelo ");
	// System.out.println("Nome modelo : " + a.getModelo().getNome());
	// System.out.println("Cavalos : " + a.getModelo().getPotencia());
	//
	// System.out.println("Dados da marca ");
	// System.out.println("Nome da Marca : " +
	// a.getModelo().getMarca().getNome());
	//
	// }
	//
	// }
	//
	// private static void incluirAutomovel(EntityManager em) {
	// Marca marca = new Marca("GM");
	// Modelo modelo = new Modelo("Gol", 110, marca);
	// Automovel automovel = new Automovel(2011, 2011, 23900.00, "Azul", 40000L,
	// modelo);
	//
	// EntityTransaction tx = em.getTransaction();
	// tx.begin();
	// em.persist(automovel);
	// tx.commit();
	//
	// // // Automovel auto = new Automovel();
	// // // auto.setAnoFabricacao(2000);
	// // // auto.setModelo(modelo);
	// // auto.setObservacoes("Velho");
	// //
	// // EntityTransaction tx = em.getTransaction();
	// // tx.begin();
	// // em.persist(auto);
	// // tx.commit();
	// }

	// private static void excluirAutomovel(EntityManager em) {
	// EntityTransaction tx = em.getTransaction();
	// Automovel_old auto = em.getReference(Automovel_old.class, 4L);
	// tx.begin();
	// em.remove(auto);
	// tx.commit();
	//
	// }
	//
	// private static void listarAutomovel(EntityManager em) {
	// String sql = "select a from Automovel a";
	// System.out.println("Query: " + sql);
	// Query q = em.createQuery(sql, Automovel.class);
	// @SuppressWarnings("unchecked")
	// List<Automovel> autos = q.getResultList();
	//
	// for(Automovel a : autos) {
	// System.out.println(a.getObservacoes());
	// }
	// }

}
