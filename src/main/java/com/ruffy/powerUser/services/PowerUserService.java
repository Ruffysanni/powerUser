package com.ruffy.powerUser.services;

import com.ruffy.powerUser.entity.PowerUser;
import com.ruffy.powerUser.repository.PowerUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PowerUserService {
    private PowerUserRepository powerUserRepository;

    public PowerUserService(PowerUserRepository powerUserRepository) {
        this.powerUserRepository = powerUserRepository;
    }

    // Get all power users
    public ResponseEntity< List<PowerUser>> getAllPowerUsers(){
        return new ResponseEntity<>(powerUserRepository.findAll(), HttpStatus.OK) ;
    }

    // Get powerUser by id
    public ResponseEntity<PowerUser> getPowerUserById(int id){
        try{
            return new ResponseEntity<>(powerUserRepository.findById(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    // Create a new power user
    public ResponseEntity<PowerUser> createNewPowerUser(PowerUser newPowerUser){
        return new ResponseEntity<>( powerUserRepository.save(newPowerUser), HttpStatus.CREATED);
    }

    // Update power user entity
    public ResponseEntity<PowerUser> updatePowerUser(int id, PowerUser updatePowerUser){
        PowerUser powerUser = powerUserRepository.findById(id).get();
        powerUser.setFirstName(updatePowerUser.getFirstName());
        powerUser.setLastName(updatePowerUser.getLastName());
        powerUser.setEmailAddress(updatePowerUser.getEmailAddress());
        powerUser.setPassWord(updatePowerUser.getPassWord());
        powerUser.setAddress(updatePowerUser.getAddress());
        powerUser.setPhoneNumber(updatePowerUser.getPhoneNumber());
        return new ResponseEntity<>( powerUserRepository.save(powerUser), HttpStatus.OK);
    }

    // Remove a power user
//    public void removePowerUser(int id){
    public ResponseEntity<PowerUser> removePowerUser(int id){
        PowerUser powerUser = powerUserRepository.findById(id).get();
        powerUserRepository.deleteById(id);
        return new ResponseEntity<>(powerUser, HttpStatus.NO_CONTENT);
    }

}
