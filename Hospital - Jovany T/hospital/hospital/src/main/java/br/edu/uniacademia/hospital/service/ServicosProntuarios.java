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

import br.edu.uniacademia.hospital.dao.ProntuariosDAO;
import br.edu.uniacademia.hospital.model.Prontuarios;

@Path("servicosProntuarios")
@RequestScoped
public class ServicosProntuarios {

	@Context
	private UriInfo context;

	public ServicosProntuarios() {

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Prontuarios pront) {
		ProntuariosDAO.getInstance().persistir(pront);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void gravar(Prontuarios pront) {
		ProntuariosDAO.getInstance().persistir(pront);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Prontuarios> buscarTodos() {
		return ProntuariosDAO.getInstance().buscarTodas();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Prontuarios buscar(Prontuarios pront) {
		return ProntuariosDAO.getInstance().buscar(pront.getDescricao());
	}

	@DELETE
	@Path("{id}")
	public void remover(Prontuarios pront) {
		ProntuariosDAO.getInstance().remover(pront);
	}

}
