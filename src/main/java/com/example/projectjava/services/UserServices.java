package com.example.projectjava.services;

import com.example.projectjava.models.User;
import com.example.projectjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserRepository repo;
    public void save(User obj){
        repo.save(obj);
    }

    public List<User> getAll(){
        return repo.findAll();
    }
}
