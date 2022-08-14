package com.MajkGroup.MajkAPP.Controllers;


import com.MajkGroup.MajkAPP.DB.Service.serviceAPI.UserService;
import com.MajkGroup.MajkAPP.Domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("user")
public class UserREST {

    private final UserService userService;

    public UserREST(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody User user){
        System.out.println(user.toString());
        user.setLogName(user.getLogName());
        user.setFullName(user.getFullName());
        Integer userDone = userService.add(user);
        if(userDone != null){
            return new ResponseEntity<>(userDone, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        User user = userService.get(id);
        if (user == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }


    @GetMapping
    public ResponseEntity getAll(){
        List<User> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

//    @GetMapping("{LogName}")
//    public ResponseEntity get(@PathVariable("LogName")String LogName){
//        User user = userService.get(LogName);
//        if(user != null) return new ResponseEntity<>(user, HttpStatus.OK);
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//
//    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        Integer value = userService.delete(id);
        if(value == 1){
            return new ResponseEntity(id, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

}
