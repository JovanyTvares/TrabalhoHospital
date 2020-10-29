package br.edu.uniacademia.hospital.service;

import br.edu.uniacademia.hospital.dao.EnderecosDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jovany
 */
@Path("servicosEnderecos")
@RequestScoped
public class ServicosEnderecos {
    
	@Context
	private UriInfo context;

	public ServicosEnderecos() {

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Enderecos end) {
		EnderecosDAO.getInstance().persistir(end);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void gravar(Enderecos end) {
		EnderecosDAO.getInstance().persistir(end);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Enderecos> buscarTodos() {
		return EnderecosDAO.getInstance().buscarTodas();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Enderecos buscar(Enderecos end) {
		return EnderecosDAO.getInstance().buscar(end.getCep());
	}

	@DELETE
	@Path("{id}")
	public void remover(Enderecos end) {
		EnderecosDAO.getInstance().remover(end);
	}
        
        
}
