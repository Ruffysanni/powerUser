package com.ruffy.powerUser.controller;

import com.ruffy.powerUser.entity.PowerUser;
import com.ruffy.powerUser.services.PowerUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class powerUserController {
    @Autowired
    private PowerUserService powerUserService;

    // Get all power users
    @GetMapping("/powerusers")
    public ResponseEntity< List<PowerUser>> getAllPowerUsers(){
        return powerUserService.getAllPowerUsers();
    }

    // Get user by id
    @GetMapping("/poweruser")
//    @GetMapping("/powerusers/{id}")
    public ResponseEntity< PowerUser> getPowerUserById(@RequestParam int id){
//    public ResponseEntity< PowerUser> getPowerUserById(@PathVariable int id){
        return powerUserService.getPowerUserById(id);
    }

    // Create new user
    @PostMapping("/poweruser")
    public ResponseEntity<PowerUser> createNewPowerUser(@RequestBody @Valid PowerUser newUser){
        return powerUserService.createNewPowerUser(newUser);
    }

    // Update existing power user
    @PutMapping("/poweruser")
//    @PutMapping("/poweruser/{id}")
    public ResponseEntity<PowerUser> updatePowerUser(@RequestParam int id, @RequestBody @Valid PowerUser updateUser){
//    public ResponseEntity<PowerUser> updatePowerUser(@PathVariable int id, @RequestBody PowerUser updateUser){
        return powerUserService.updatePowerUser(id, updateUser);
    }

    // Delete existing power user
    @DeleteMapping("/poweruser/{id}")
    public ResponseEntity<PowerUser> removePowerUser(@PathVariable int id){
        return powerUserService.removePowerUser(id);
    }
}
