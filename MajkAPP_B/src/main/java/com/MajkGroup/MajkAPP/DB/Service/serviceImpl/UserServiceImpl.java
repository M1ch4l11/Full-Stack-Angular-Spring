package com.MajkGroup.MajkAPP.DB.Service.serviceImpl;

import com.MajkGroup.MajkAPP.DB.Repository.UserRepository;
import com.MajkGroup.MajkAPP.DB.Service.serviceAPI.UserService;
import com.MajkGroup.MajkAPP.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }


    @Override
    public Integer add(User user) {
        return repository.add(user);
    }

    @Override
    public Integer delete(int id) {
        return repository.delete(id);
    }
}
