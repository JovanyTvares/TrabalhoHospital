package br.edu.uniacademia.hospital.service;

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

import br.edu.uniacademia.hospital.dao.FuncionariosDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;

@Path("servicosFuncionarios")
@RequestScoped
public class ServicosFuncionarios {

	@Context
	private UriInfo context;

	public ServicosFuncionarios() {

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Funcionarios func) {
		FuncionariosDAO.getInstance().persistir(func);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void gravar(Funcionarios func) {
		FuncionariosDAO.getInstance().persistir(func);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionarios> buscarTodos() {
		return FuncionariosDAO.getInstance().buscarTodas();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Funcionarios buscar(Funcionarios func) {
		return FuncionariosDAO.getInstance().buscar(func.getNomeFuncionario());
	}

	@DELETE
	@Path("{id}")
	public void remover(Funcionarios func) {
		FuncionariosDAO.getInstance().remover(func);
	}

}
