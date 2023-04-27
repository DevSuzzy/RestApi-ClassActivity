package com.susancodes.restapi.Controller;

import com.susancodes.restapi.Dto.UserDto;
import com.susancodes.restapi.Entity.User;
import com.susancodes.restapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/user")
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/Sign-up")
    public User createUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);

    }

    @GetMapping("/view-all-users")
    public List<User> allUsers() {
        return userService.findAll();

    }
    @PutMapping("/update{id}")
    public User updateUser(@PathVariable Long id, UserDto) {
        User existingUser = UserService.findById(id);
        existingUser.setUserName(UserDto.getuserName());
        existingUser.setPassword(UserDto.getuserName());
        return UserService.saveUser(existingUser);


    }
    @DeleteMapping("/delete{id}")
    public String deleteUser(@PathVariable Long id){


    }



}