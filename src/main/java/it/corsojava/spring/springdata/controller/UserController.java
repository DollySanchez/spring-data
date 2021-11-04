package it.corsojava.spring.springdata.controller;

import it.corsojava.spring.springdata.model.User;
import it.corsojava.spring.springdata.repository.ItemRepository;
import it.corsojava.spring.springdata.repository.OrderRepository;
import it.corsojava.spring.springdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("saveUser")
    public void saveUsers(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("getUsers")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        for (User u:users) System.out.println(u);
        return users;
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(@RequestParam String userId){
        userRepository.delete(userRepository.getById(Long.valueOf(userId)));
    }

    @PostMapping("updateUser")
    public void updateUser(@RequestBody User user, @RequestParam String userId){
        user.setId(Long.valueOf(userId));
        userRepository.save(user);
    }




}
