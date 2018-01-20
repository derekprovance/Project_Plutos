package com.derekprovance.plutos.service;

import com.derekprovance.plutos.data.UserSingleton;
import com.derekprovance.plutos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public void loginUser() {
        UserSingleton.getInstance().setUser(userRepository.getUserByEmail("derek@provance.me"));
    }
}
