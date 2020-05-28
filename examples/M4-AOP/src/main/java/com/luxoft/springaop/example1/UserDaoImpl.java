package com.luxoft.springaop.example1;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao { 
	
	private static Map<Integer, UserDTO> userIdToUserDto = new HashMap<Integer, UserDTO>();
	
	public UserDTO getUser(int id)
	{
		if (null != userIdToUserDto.get(id))
		{
			return userIdToUserDto.get(id);
		}
		
		UserDTO user = new UserDTO(id);
		userIdToUserDto.put(id, user);

		return user;
	}

}
