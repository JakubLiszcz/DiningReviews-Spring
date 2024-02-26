package com.example.springProject.controller;

import com.example.springProject.repository.UsersRepository;
import com.example.springProject.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable("id") Long id){
        return usersRepository.findById(id);}

    @PostMapping("/newUser")
    public Users createNewUser(@RequestBody Users user){
        return usersRepository.save(user);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Users updateUser (@PathVariable("id") Long id, @RequestBody Users user) {
        return usersRepository.findById(id)
                .map(city -> {
                    city.setCity(user.getCity());
                    return usersRepository.save(city);
                })
                .map(state -> {
                    state.setState(user.getState());
                    return usersRepository.save(state);
                })
                .map(zipCode -> {
                    zipCode.setZipCode(user.getZipCode());
                    return usersRepository.save(zipCode);
                })
                .orElseGet(() -> {
                    return usersRepository.save(user);
                });
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser (@PathVariable("id") Long id){
        usersRepository.deleteById(id);
        return "Successfully delete user: " + id;
    }

}