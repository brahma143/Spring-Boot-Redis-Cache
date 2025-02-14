package com.redisCache.Service;

import com.redisCache.Entity.User;
import com.redisCache.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users",key = "#id")
    public User getByUserId(Long id){
        Object Supplier;
        return userRepository.findById(id).orElseThrow(null);
    }

    @CachePut(value = "users", key="#user.id")
    public User saveUser(User user){

        return userRepository.save(user);
    }

    @CacheEvict(value = "users",key = "#id")
    public void deleteByUserId(Long id){

        userRepository.deleteById(id);
    }

}















