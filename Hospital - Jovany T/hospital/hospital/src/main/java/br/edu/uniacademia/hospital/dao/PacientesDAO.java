package br.edu.uniacademia.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.util.PersistenceUtil;

public class PacientesDAO {

	public static PacientesDAO pacientesDAO;

	public static PacientesDAO getInstance() {
		if (pacientesDAO == null) {
			pacientesDAO = new PacientesDAO();
		}

		return pacientesDAO;
	}

	public Pacientes buscar(String nome) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("select a from Pacientes a where a.nomePaciente =:nome ");
		query.setParameter("nome", nome);

		List<Pacientes> pacientesList = query.getResultList();
		if (pacientesList != null && pacientesList.size() > 0) {
			return pacientesList.get(0);
		}

		return null;
	}
        
        public Pacientes FindById(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Pacientes a where a.idPaciente =:id ");
            query.setParameter("id", id);
          List<Pacientes> pacientesList = query.getResultList();
          if(pacientesList != null && pacientesList.size() > 0){
                return pacientesList.get(0);
            }
            
            return null;
        }
        
	public List<Pacientes> buscarTodas() {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("from Pacientes As a");
		
		return query.getResultList();
	}

	public void remover(Pacientes pacientes) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		if (!em.contains(pacientes)) {
			pacientes = em.merge(pacientes);
		}
		
		em.remove(pacientes);
		em.getTransaction().commit();
	}

	public Pacientes persistir(Pacientes pacientes) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		try {
			pacientes = em.merge(pacientes);
			em.getTransaction().commit();
			
			System.out.println("Registro Pacientes gravado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pacientes;
	}

	public void removeAll() {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery(" delete from Pacientes ");
		query.executeUpdate();
		
		em.getTransaction().commit();
	}
}
