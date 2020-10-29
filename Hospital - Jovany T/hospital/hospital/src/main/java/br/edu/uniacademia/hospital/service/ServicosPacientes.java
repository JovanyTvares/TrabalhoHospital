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

import br.edu.uniacademia.hospital.dao.PacientesDAO;
import br.edu.uniacademia.hospital.model.Pacientes;

@Path("servicosPacientes")
@RequestScoped
public class ServicosPacientes {

	@Context
	private UriInfo context;

	public ServicosPacientes() {

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Pacientes pac) {
		PacientesDAO.getInstance().persistir(pac);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void gravar(Pacientes pac) {
		PacientesDAO.getInstance().persistir(pac);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pacientes> buscarTodos() {
		return PacientesDAO.getInstance().buscarTodas();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pacientes buscar(Pacientes pac) {
		return PacientesDAO.getInstance().buscar(pac.getNomePaciente());
	}

	@DELETE
	@Path("{id}")
	public void remover(Pacientes pac) {
		PacientesDAO.getInstance().remover(pac);
	}

}
