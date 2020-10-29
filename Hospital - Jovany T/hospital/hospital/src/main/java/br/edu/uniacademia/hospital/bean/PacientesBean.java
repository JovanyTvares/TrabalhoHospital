package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.uniacademia.hospital.dao.PacientesDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Pacientes;

@Named
@ViewScoped
public class PacientesBean implements Serializable {

    List pacientesList = new ArrayList();
    Pacientes pacientes = new Pacientes();

    long enderecoId = 0;

    public PacientesBean() {
        pacientesList = new PacientesDAO().buscarTodas();
        pacientes = new Pacientes();
    }

    public void salvar(ActionEvent actionEvent) {
        
        Enderecos endereco = new EnderecosDAO().FindById(enderecoId);
        
        pacientes.setEndereco(endereco);

        new PacientesDAO().persistir(pacientes);
        pacientesList = new PacientesDAO().buscarTodas();
        pacientes = new Pacientes();
    }

    public void remover(ActionEvent actionEvent) {
        new PacientesDAO().remover(pacientes);
        pacientesList = new PacientesDAO().buscarTodas();
        pacientes = new Pacientes();
    }

    public Pacientes getTipoPaciente() {
        return pacientes;
    }

    public void setTipoPaciente(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public List getTipoPacientes() {
        return pacientesList;
    }

    public void setTipoPacientes(List pacientesList) {
        this.pacientesList = pacientesList;
    }

    public long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(long enderecoId) {
        this.enderecoId = enderecoId;
    }

}
