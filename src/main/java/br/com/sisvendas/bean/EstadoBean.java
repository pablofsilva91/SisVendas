package br.com.sisvendas.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sisvendas.dao.EstadoDAO;
import br.com.sisvendas.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void novo(){
		estado = new Estado();
	}
	
	public void salvar(){
		try{
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);
			
			novo();
			
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
}
