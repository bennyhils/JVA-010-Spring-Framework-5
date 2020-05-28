package com.luxoft.springaop.example3;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl {

    private static Map<Integer, UserDTO> userDaoMap = new HashMap<Integer, UserDTO>();

    public UserDTO getUser(int id) {
        if (null != userDaoMap.get(id)) {
            return userDaoMap.get(id);
        }

        UserDTO user = new UserDTO(id);
        userDaoMap.put(id, user);

        if (id < 1) {
            throw new RuntimeException("incorrect id");
        }

        return user;
    }

}
