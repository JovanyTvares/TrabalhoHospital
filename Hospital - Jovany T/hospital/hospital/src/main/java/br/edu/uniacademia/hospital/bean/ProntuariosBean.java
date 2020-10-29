package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.FuncionariosDAO;
import br.edu.uniacademia.hospital.dao.PacientesDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.uniacademia.hospital.dao.ProntuariosDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.model.Prontuarios;

@Named
@ViewScoped
public class ProntuariosBean implements Serializable {

    List prontuariosList = new ArrayList();
    Prontuarios prontuarios = new Prontuarios();

    long funcionarioId = 0;
    long pacienteId = 0;

    public ProntuariosBean() {
        prontuariosList = new ProntuariosDAO().buscarTodas();
        prontuarios = new Prontuarios();
    }

    public void salvar(ActionEvent actionEvent) {
        
        Funcionarios funcionario = new FuncionariosDAO().FindById(funcionarioId);
        Pacientes pacientes = new PacientesDAO().FindById(pacienteId);
        
        prontuarios.setFuncionariosidFuncionario(funcionario);
        prontuarios.setPacientesidPaciente(pacientes);

        new ProntuariosDAO().persistir(prontuarios);
        prontuariosList = new ProntuariosDAO().buscarTodas();
        prontuarios = new Prontuarios();
    }

    public void remover(ActionEvent actionEvent) {
        new ProntuariosDAO().remover(prontuarios);
        prontuariosList = new ProntuariosDAO().buscarTodas();
        prontuarios = new Prontuarios();
    }

    public Prontuarios getTipoProntuario() {
        return prontuarios;
    }

    public void setTipoProntuario(Prontuarios prontuarios) {
        this.prontuarios = prontuarios;
    }

    public List getTipoProntuarios() {
        return prontuariosList;
    }

    public void setTipoProntuarios(List prontuariosList) {
        this.prontuariosList = prontuariosList;
    }

    public long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(long pacienteId) {
        this.pacienteId = pacienteId;
    }

}
