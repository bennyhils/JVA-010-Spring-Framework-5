package com.luxoft.springioc.example35;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public ClientService getClientService() {

		ClientService clientService = new ClientService() {

			@Autowired
			ClientDao clientDao;

			@Override
			public void setDao(ClientDao dao) {

				clientDao = dao;
			}

			@Override
			public void doTheJob() {
				System.out.println("--> " + (clientDao != null ? clientDao.getClass().getSimpleName() : "null"));
			}
		};

//		clientService.setDao(getClientDao());

		return clientService;
	}

	@Bean(name = "person")
	public  PersonBean personBean() {
		return new PersonBean("person", getClientDao());
	}

	@Bean(name = "dao")
	public ClientDao getClientDao() {

//		return new ClientDao() {}; // weird
		return new ClientDaoImpl();
	}
	public static class PersonBean {
		private final ClientDao clientDao;
		private String name;

		public  PersonBean(String name, ClientDao clientDao) {
			this.name = name;
			this.clientDao = clientDao;
		}

		public ClientDao getClientDao() {
			return clientDao;
		}
	}
}
