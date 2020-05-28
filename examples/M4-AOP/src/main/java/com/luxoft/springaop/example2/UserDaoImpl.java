package com.luxoft.springaop.example2;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl { 
	
	private static Map<Integer, UserDTO> userDaoMap = new HashMap<Integer, UserDTO>();

//	@Log
	public UserDTO getUser(int id) {
		if (null != userDaoMap.get(id)) {
			return userDaoMap.get(id);
		}
		
		UserDTO user = new UserDTO(id);
		userDaoMap.put(id, user);
		return user;
	}

}
