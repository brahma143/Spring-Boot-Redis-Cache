package com.redisCache.Controller;

import com.redisCache.Entity.User;
import com.redisCache.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUserDetails(@RequestBody User user){

        return  new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findByUserId(@PathVariable Long userId){

            User user = userService.getByUserId(userId);
        return  user != null? ResponseEntity.ok(user):ResponseEntity.noContent().build();
                //new ResponseEntity<>(userService.getByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteByUserId(@PathVariable Long userId){
        userService.deleteByUserId(userId);
        return ResponseEntity.noContent().build();
                //"userid deleted successfully "+ userId;
    }

//    @DeleteMapping("/{userId}")
//    public String deleteByUserId(@PathVariable Long userId){
//        userService.deleteByUserId(userId);
//        return "userid deleted successfully "+ userId;
//    }


}















