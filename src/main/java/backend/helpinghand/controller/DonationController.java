package backend.helpinghand.controller;

import backend.helpinghand.entities.Donation;
import backend.helpinghand.entities.Organization;
import backend.helpinghand.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helpinghands")
@CrossOrigin("*")
public class DonationController {
    @Autowired
    DonationService donationService;

    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> listAllDonations() {
        return new ResponseEntity<>(donationService.listAllDonations(), HttpStatus.OK);
    }


    @PostMapping("/donations")
    public ResponseEntity<Donation>  addDonation(@RequestBody Donation donation) {
        Donation newDonation = donationService.addDonation(donation);
        return new ResponseEntity<>(newDonation, HttpStatus.OK);
    }

}
