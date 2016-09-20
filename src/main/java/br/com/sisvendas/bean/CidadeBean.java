package br.com.sisvendas.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sisvendas.dao.CidadeDAO;
import br.com.sisvendas.dao.EstadoDAO;
import br.com.sisvendas.domain.Cidade;
import br.com.sisvendas.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;
	
	public List<Cidade> getCidades(){
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao listar as cidades");
		}
	}
	
	public void novo(){
		try{
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();	
			estados = estadoDAO.listar();
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidades");
		}
	}
	
	public void salvar(){
		try{
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			
			cidade = new Cidade();
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			cidades = cidadeDAO.listar();
			
		}catch(RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao listar as cidades");
		}
	}
	
	public void excluir(ActionEvent evento){ //captura o que foi mandado na visão
		try{
		
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
		
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			
			cidades = cidadeDAO.listar();
		
			Messages.addGlobalInfo("Cidade excluido com sucesso!");
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a cidade");
			erro.printStackTrace();
		}
	}

}
