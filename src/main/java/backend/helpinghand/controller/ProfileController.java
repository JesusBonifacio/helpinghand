package backend.helpinghand.controller;


import backend.helpinghand.entities.Campaign;
import backend.helpinghand.entities.Donation;
import backend.helpinghand.entities.Profile;
import backend.helpinghand.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helpinghands")
@CrossOrigin("*")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> listAllProfiles() {
        return new ResponseEntity<>(profileService.listAllProfiles(), HttpStatus.OK);
    }


    @PostMapping("/profiles")
    public ResponseEntity<Profile>  addProfile(@RequestBody Profile profile) {
        Profile newProfile = profileService.addProfile(profile);
        return new ResponseEntity<>(newProfile, HttpStatus.OK);
    }

    @PutMapping("/profiles/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") Long id, @RequestBody Profile profile){
        profile.setId(id);
        Profile updateProfile = profileService.updateProfile(profile);
        return new ResponseEntity<>(updateProfile, HttpStatus.OK);
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<HttpStatus> deleteProfile( @PathVariable("id") Long id){
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/profiles/email/{email}")
    public ResponseEntity<List<Profile>> getProfilesByEmail(@PathVariable("email") String email) {
        List<Profile> profiles = profileService.listByEmail(email);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/profiles/name/{name}")
    public ResponseEntity<List<Profile>> getProfilesByName(@PathVariable("name") String name) {
        List<Profile> profiles = profileService.listByName(name);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/profiles/address/{address}")
    public ResponseEntity<List<Profile>> getProfilesByAddress(@PathVariable("address") String address) {
        List<Profile> profiles = profileService.listByAddress(address);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/profiles/phone/{phone}")
    public ResponseEntity<List<Profile>> getProfilesByPhone(@PathVariable("phone") String phone) {
        List<Profile> profiles = profileService.listByPhone(phone);
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

}
