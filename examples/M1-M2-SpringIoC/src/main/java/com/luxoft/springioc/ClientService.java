package com.luxoft.springioc;

public class ClientService {
	private String serviceType;
	private boolean isRemote; 


	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public boolean isRemote() {
		return isRemote;
	}

	public void setRemote(boolean isRemote) {
		this.isRemote = isRemote;
	}

	public static ClientService createInstance(String serviceType) {
		ClientService clientService = new ClientService();
		clientService.setServiceType(serviceType);
		if (serviceType.equals("Software Development")) {
			clientService.setRemote(true);
		}
		// possibly perform some other operations 
		// with clientService instance
		return clientService;
	}
	
	public String toString() {
		return serviceType + " remote: " + isRemote; 
	}

}
