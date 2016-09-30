package br.com.sisvendas.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.omnifaces.util.Messages;

import br.com.sisvendas.dao.PessoaDAO;
import br.com.sisvendas.domain.Pessoa;

@SuppressWarnings("serial")
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	@PostConstruct
	public void listar(){
		try{
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
			
		}catch (RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao listar as pessoas");
			erro.printStackTrace();
		}
	}
	
}
