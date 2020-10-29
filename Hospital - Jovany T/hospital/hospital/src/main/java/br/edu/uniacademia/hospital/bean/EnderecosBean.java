/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecosDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jovany
 */
@Named
@ViewScoped
public class EnderecosBean implements Serializable {
    
        Enderecos enderecos = new Enderecos();

	List enderecosList = new ArrayList();

	public EnderecosBean() {
		enderecosList = new EnderecosDAO().buscarTodas();
		enderecos = new Enderecos();
	}

	public void salvar(ActionEvent actionEvent) {
		new EnderecosDAO().persistir(enderecos);
		enderecosList = new EnderecosDAO().buscarTodas();
		enderecos = new Enderecos();
	}

	public void remover(ActionEvent actionEvent) {
		new EnderecosDAO().remover(enderecos);
		enderecosList = new EnderecosDAO().buscarTodas();
		enderecos = new Enderecos();
	}

	public Enderecos getEndereco() {
		return enderecos;
	}

	public void setEndereco(Enderecos enderecos) {
		this.enderecos = enderecos;
	}

	public List getEnderecosList() {
		return enderecosList;
	}

	public void setEnderecosList(List enderecosList) {
		this.enderecosList = enderecosList;
	}
}
