package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jovany
 */
public class EnderecosDAO {   

	public static EnderecosDAO enderecosDAO;
        public static Long idEndereco;
        
	public static EnderecosDAO getInstance() {
		if (enderecosDAO == null) {
			enderecosDAO = new EnderecosDAO();
		}

		return enderecosDAO;
	}

	public Enderecos buscar(String cep) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("select a from Enderecos a where a.cep =:cep ");
		query.setParameter("cep", cep);

		List<Enderecos> enderecosList = query.getResultList();
		if (enderecosList != null && enderecosList.size() > 0) {
			return enderecosList.get(0);
		}

		return null;
	}
        
        public Enderecos FindById(Long id) {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("select a from Enderecos a where a.idEndereco =:id ");
            query.setParameter("id", id);
            
            List<Enderecos> enderecosList = query.getResultList();
            if(enderecosList != null && enderecosList.size() > 0){
                return enderecosList.get(0);
            }
            
            return null;
        }
        
	public List<Enderecos> buscarTodas() {
		EntityManager em = PersistenceUtil.getEntityManager();
		Query query = em.createQuery("from Enderecos As a");
		
		return query.getResultList();
	}

	public void remover(Enderecos enderecos) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		if (!em.contains(enderecos)) {
			enderecos = em.merge(enderecos);
		}
		
		em.remove(enderecos);
		em.getTransaction().commit();
	}

	public Enderecos persistir(Enderecos enderecos) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		try {
			enderecos = em.merge(enderecos);
			em.getTransaction().commit();
			
			System.out.println("Registro Enderecos gravado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return enderecos;
	}

	public void removeAll() {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery(" delete from Enderecos ");
		query.executeUpdate();
		
		em.getTransaction().commit();
	}        
}
