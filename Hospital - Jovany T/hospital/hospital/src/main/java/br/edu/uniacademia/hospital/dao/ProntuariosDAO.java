package br.edu.uniacademia.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.uniacademia.hospital.model.Prontuarios;
import br.edu.uniacademia.hospital.util.PersistenceUtil;

public class ProntuariosDAO {

	public static ProntuariosDAO prontuariosDAO;

	public static ProntuariosDAO getInstance() {
		if (prontuariosDAO == null) {
			prontuariosDAO = new ProntuariosDAO();
		}

		return prontuariosDAO;
	}

	public Prontuarios buscar(String descricao) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("select a from Prontuarios a where a.descricao =:descricao ");
		query.setParameter("descricao", descricao);

		List<Prontuarios> prontuariosList = query.getResultList();
		if (prontuariosList != null && prontuariosList.size() > 0) {
			return prontuariosList.get(0);
		}

		return null;
	}

	public List<Prontuarios> buscarTodas() {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("from Prontuarios As a");

		return query.getResultList();
	}

	public void remover(Prontuarios prontuarios) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();

		if (!em.contains(prontuarios)) {
			prontuarios = em.merge(prontuarios);
		}

		em.remove(prontuarios);
		em.getTransaction().commit();
	}

	public Prontuarios persistir(Prontuarios prontuarios) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();

		try {
			prontuarios = em.merge(prontuarios);
			em.getTransaction().commit();

			System.out.println("Registro Prontuarios gravado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prontuarios;
	}

	public void removeAll() {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery(" delete from Prontuarios ");
		query.executeUpdate();

		em.getTransaction().commit();
	}
}
