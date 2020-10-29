package br.edu.uniacademia.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.util.PersistenceUtil;

public class FuncionariosDAO {

	public static FuncionariosDAO funcionariosDAO;

	public static FuncionariosDAO getInstance() {
		if (funcionariosDAO == null) {
			funcionariosDAO = new FuncionariosDAO();
		}

		return funcionariosDAO;
	}

	public Funcionarios buscar(String nome) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("select a from Funcionarios a where a.nomeFuncionario =:nome ");
		query.setParameter("nome", nome);

		List<Funcionarios> funcionariosList = query.getResultList();
		if (funcionariosList != null && funcionariosList.size() > 0) {
			return funcionariosList.get(0);
		}

		return null;
	}
        
        public Funcionarios FindById(Long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Funcionarios a where a.idFuncionario =:id ");
        query.setParameter("id", id);
        
          List<Funcionarios> funcionariosList = query.getResultList();
          if(funcionariosList != null && funcionariosList.size() > 0){
                return funcionariosList.get(0);
            }
            
            return null;
        }
        

	public List<Funcionarios> buscarTodas() {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("from Funcionarios As a");
		
		return query.getResultList();
	}

	public void remover(Funcionarios funcionarios) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		if (!em.contains(funcionarios)) {
			funcionarios = em.merge(funcionarios);
		}
		
		em.remove(funcionarios);
		em.getTransaction().commit();
	}

	public Funcionarios persistir(Funcionarios funcionarios) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		try {
			funcionarios = em.merge(funcionarios);
			em.getTransaction().commit();
			
			System.out.println("Registro Funcionarios gravado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return funcionarios;
	}

	public void removeAll() {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery(" delete from Funcionarios ");
		query.executeUpdate();
		
		em.getTransaction().commit();
	}
}
