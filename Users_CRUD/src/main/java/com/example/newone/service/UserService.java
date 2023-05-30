package com.example.newone.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.newone.entity.User;

public interface UserService {

    public List<User> findAll();

    public Optional<User> findById(UUID id);


    public void save(User user);

    public void deleteById(UUID id);

}
