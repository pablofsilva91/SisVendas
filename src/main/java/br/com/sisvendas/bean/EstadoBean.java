package br.com.sisvendas.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sisvendas.dao.EstadoDAO;
import br.com.sisvendas.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct//depois do managed bean criado ele chama automaticamente o metodo listar
	public void listar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar o Estado!");
			erro.printStackTrace();
		}
	}
	
	public void novo(){
		estado = new Estado();
	}
	
	public void salvar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado); //merge: salva um novo ou atualiza
			
			estado = new Estado();
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado salvo com sucesso!");
	
			//throw new RuntimeException("Erro forçado!");
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Estado!");
			erro.printStackTrace();
		}
//		String msg = "Estado salvo com sucesso!";
//		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
//		
//		FacesContext contexto = FacesContext.getCurrentInstance();
//		contexto.addMessage(null, message);
	}
	
	public void excluir(ActionEvent evento){ //captura o que foi mandado na visão
		try{
		
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listar();
		
			Messages.addGlobalInfo("Estado excluido com sucesso!");
			Messages.addGlobalInfo("Nome: " + estado.getNome() + "Sigla: " + estado.getSigla());
		}catch (RuntimeException erro){
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){ //captura o que foi mandado na visão
		
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
	}
	
}
