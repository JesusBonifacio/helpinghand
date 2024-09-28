package backend.helpinghand.serviceimpl;

import backend.helpinghand.entities.Donation;
import backend.helpinghand.repositories.DonationRepository;
import backend.helpinghand.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public List<Donation> listAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Donation addDonation(Donation donation) {
        return donationRepository.save(donation);
    }
}
