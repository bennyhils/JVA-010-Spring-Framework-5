package com.luxoft.springioc.example15;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Customer {
	private List<Object> list;
	private Set<Object> set;
	private Map<Object, Object> map;
	private Map<String, Object> stringsMap;
	private Map<Person, String> personsMap;
	private Properties props;
	
	public List<Object> getList() {
		return list;
	}
	
	public void setList(List<Object> list) {
		this.list = list;
	}
	
	public Set<Object> getSet() {
		return set;
	}

	public void setSet(Set<Object> set) {
		this.set = set;
	}
	
	public Map<Object, Object> getMap() {
		return map;
	}

	public void setMap(Map<Object, Object> map) {
		this.map = map;
	}
	
	public Map<String, Object> getStringsMap() {
		return stringsMap;
	}

	public void setStringsMap(Map<String, Object> stringsMap) {
		this.stringsMap = stringsMap;
	}

	public Map<Person, String> getPersonsMap() {
		return personsMap;
	}

	public void setPersonsMap(Map<Person, String> personsMap) {
		this.personsMap = personsMap;
	}
	
	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

}
