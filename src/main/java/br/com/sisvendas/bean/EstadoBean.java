package br.com.sisvendas.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sisvendas.domain.Estado;

@ManagedBean
@ViewScoped
public class EstadoBean {
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
		Messages.addGlobalInfo("Estado salvo com sucesso!");
		Messages.addGlobalInfo("Nome: "+ estado.getNome() + " Sigla: " + estado.getSigla());
//		String msg = "Estado salvo com sucesso!";
//		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
//		
//		FacesContext contexto = FacesContext.getCurrentInstance();
//		contexto.addMessage(null, message);
	}
}
