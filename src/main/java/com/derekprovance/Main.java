package com.derekprovance;

import com.derekprovance.data.UserSingleton;
import com.derekprovance.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);

        //TODO - abstract out to login controller
        UserSingleton.getInstance().setUser(UserRepository.getUserByEmail("derek@provance.me"));
    }
}
