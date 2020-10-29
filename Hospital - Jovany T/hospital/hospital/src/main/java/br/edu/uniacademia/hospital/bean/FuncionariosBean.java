package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.edu.uniacademia.hospital.dao.FuncionariosDAO;
import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.TipoFuncionario;

@Named
@ViewScoped
public class FuncionariosBean implements Serializable {

    Funcionarios funcionarios = new Funcionarios();

    long enderecoId = 0;
    long tipoFuncionarioId = 0;

    List funcionariosList = new ArrayList();

    public FuncionariosBean() {
        funcionariosList = new FuncionariosDAO().buscarTodas();
        funcionarios = new Funcionarios();
    }

    public void salvar(ActionEvent actionEvent) {

        Enderecos endereco = new EnderecosDAO().FindById(enderecoId);
        TipoFuncionario tipoFuncionario = new TipoFuncionarioDAO().FindById(tipoFuncionarioId);

        funcionarios.setEnderecosidEnderecos(endereco);
        funcionarios.setTipoFuncionarioidtipoFuncionario(tipoFuncionario);

        new FuncionariosDAO().persistir(funcionarios);
        funcionariosList = new FuncionariosDAO().buscarTodas();
        funcionarios = new Funcionarios();
    }

    public void remover(ActionEvent actionEvent) {
        new FuncionariosDAO().remover(funcionarios);
        funcionariosList = new FuncionariosDAO().buscarTodas();
        funcionarios = new Funcionarios();
    }

    public Funcionarios getFuncionario() {
        return funcionarios;
    }

    public void setFuncionario(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List getFuncionarios() {
        return funcionariosList;
    }

    public void setFuncionarios(List funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    public List getFuncionariosList() {
        return funcionariosList;
    }

    public void setFuncionariosList(List funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    public long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public long getTipoFuncionarioId() {
        return tipoFuncionarioId;
    }

    public void setTipoFuncionarioId(long tipoFuncionarioId) {
        this.tipoFuncionarioId = tipoFuncionarioId;
    }

}
