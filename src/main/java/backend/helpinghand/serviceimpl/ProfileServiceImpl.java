package backend.helpinghand.serviceimpl;

import backend.helpinghand.entities.Profile;
import backend.helpinghand.exceptions.InvalidDataException;
import backend.helpinghand.exceptions.ResourceNotFoundException;
import backend.helpinghand.repositories.ProfileRepository;
import backend.helpinghand.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;


    @Override
    public Profile findProfileById(Long id) throws ResourceNotFoundException {
        Profile profileFound = profileRepository.findById(id).orElse(null);
        return profileFound;
    }


    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> listAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Profile profileFound = findProfileById(profile.getId());
        if (profileFound != null) {
            if (profile.getName() != null) {
                if(profileFound.getName().isBlank()) {
                    throw new InvalidDataException("Profile name cannot be blank");
                }
                profileFound.setName(profile.getName());
            }
            if(profile.getEmail() != null) {
                if(profile.getEmail().isBlank()) {
                    throw new InvalidDataException("Profile email cannot be blank");
                }
                profileFound.setEmail(profile.getEmail());
            }
            if(profile.getPhone() != null) {
                if(profile.getPhone().isBlank()) {
                    throw new InvalidDataException("Profile phone cannot be blank");
                }
            }
            if(profile.getAddress() != null) {
                if(profile.getAddress().isBlank()) {
                    throw new InvalidDataException("Profile address cannot be blank");
                }
            }
            if(profile.getBirthdate()!=null) {
                profileFound.setBirthdate(profile.getBirthdate());
            }

            return profileRepository.save(profileFound);
        }
        else {
            throw new ResourceNotFoundException("Profile with id: "+profile.getId()+" not found");
        }

    }

    @Override
    public void deleteProfile(Long id) {
        Profile profileFound = findProfileById(id);
        if (profileFound == null) {
            throw new ResourceNotFoundException("Profile with id: "+id+" not found");
        }
        if(!profileFound.getComments().isEmpty()) {
            throw new InvalidDataException("Profile with id: "+id+" cannot be deleted because is used in FK Comments");
        }
        if(!profileFound.getDonations().isEmpty()) {
            throw new InvalidDataException("Profile with id:" +id+" cannot be deleted because is used in FK Donations");
        }
        profileRepository.delete(profileFound);

    }

    @Override
    public List<Profile> listByEmail(String email) {
        return profileRepository.findByEmailContains(email);
    }

    @Override
    public List<Profile> listByName(String name) {

        return profileRepository.findByNameContains(name);
    }

    @Override
    public List<Profile> listByAddress(String address) {

        return profileRepository.findByAddressContains(address);
    }

    @Override
    public List<Profile> listByPhone(String phone) {

        return profileRepository.findByPhoneContains(phone);
    }
}
