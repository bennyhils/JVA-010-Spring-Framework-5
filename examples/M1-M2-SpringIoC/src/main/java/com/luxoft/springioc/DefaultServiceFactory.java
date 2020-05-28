package com.luxoft.springioc;

public class DefaultServiceFactory {
	
	public ClientService createClientServiceInstance(String serviceType) {
		ClientService clientService = new ClientService();
		clientService.setServiceType(serviceType);
		if (serviceType.equals("Software Development")) {
			clientService.setRemote(true);
		}
		// possibly perform some other operations 
		// with clientService instance
		return clientService;
	}

	public ClientService createClientServiceInstance2(String serviceType) {
		ClientService clientService = new ClientService();
		clientService.setServiceType(serviceType);
		if (serviceType.equals(" Development")) {
			clientService.setRemote(true);
		}
		// possibly perform some other operations
		// with clientService instance
		return clientService;
	}

}
