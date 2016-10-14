package br.com.sisvendas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sisvendas.dao.CidadeDAO;
import br.com.sisvendas.dao.EstadoDAO;
import br.com.sisvendas.dao.PessoaDAO;
import br.com.sisvendas.domain.Cidade;
import br.com.sisvendas.domain.Estado;
import br.com.sisvendas.domain.Pessoa;

@ViewScoped
@ManagedBean
@SuppressWarnings("serial")
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private List<Estado> estados;
	
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
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
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
	
	public void novo(){
		try{
			pessoa = new Pessoa();
		
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		
			cidades = new ArrayList<Cidade>();//lista vazia
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar a Pessoa");
			erro.printStackTrace();
		}
	}
	
	public void salvar(){
//		try{
//			PessoaDAO pessoaDAO = new PessoaDAO();
//			pessoaDAO.merge(pessoa);
//			
//			pessoa = new Pessoa();
//			
//			EstadoDAO estadoDAO = new EstadoDAO();
//			estados = estadoDAO.listar();
//			CidadeDAO cidadeDAO = new CidadeDAO();
//			cidades = cidadeDAO.listar();
//			pessoas = pessoaDAO.listar();
//			
//		}catch(RuntimeException erro){
//			Messages.addFlashGlobalError("Ocorreu um erro ao listar as cidades");
//		}
	}
	
	public void excluir(){
		
	}
	
	public void editar(){
		
	}
}
