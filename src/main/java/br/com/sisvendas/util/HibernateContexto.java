package br.com.sisvendas.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	//fecha a fábrica de conexões
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes().close();
		
	}
	//iniciaçao do tomcat, força o tomcat a iniciar o hibernate, torna o carregamento da página mais rápido
	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes();
		
	}

}
