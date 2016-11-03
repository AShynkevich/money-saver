package com.deniel.ms.repository.sql.jdbc;

import com.deniel.ms.domain.user.IUser;
import com.deniel.ms.domain.user.User;
import com.deniel.ms.repository.sql.jdbc.user.UserRepository;

/**
 * Created by DenielNote on 03.11.2016.
 */
public class TestClass {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        IUser user = new User();
        user.setName("Ohlomon");
        user.setId("1234567890");
        user.setLogin("deathforlemmings");
        user.setPass("1234");
        user.setActiveFlag(true);

        userRepository.create(user);

        userRepository.delete("fb2a7244-ec9d-4c8c-a4c2-6c93e9e3f182");

        System.out.println(userRepository.read("1234567890").getName());
    }
}
