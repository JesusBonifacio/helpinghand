package backend.helpinghand.services;

import backend.helpinghand.entities.Donation;

import java.util.List;

public interface DonationService {
    public List<Donation> listAllDonations();
    public Donation addDonation(Donation donation);
}
