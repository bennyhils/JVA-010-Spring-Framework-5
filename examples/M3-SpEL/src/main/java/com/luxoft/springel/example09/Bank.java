package com.luxoft.springel.example09;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String bName;

    private List<Client> clients = new ArrayList<Client>();

    public Bank(String bName) {
    	this.bName = bName;
    }
    
    public void addClient(Client client) {
    	clients.add(client);
    }
    
    public List<Client> getClients() {
        return clients;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

}
