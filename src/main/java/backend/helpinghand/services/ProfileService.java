package backend.helpinghand.services;

import backend.helpinghand.entities.Profile;

import java.util.List;

public interface ProfileService {
    public Profile addProfile(Profile profile);
    public List<Profile> listAllProfiles();
    public Profile updateProfile(Profile profile);
    public Profile findProfileById(Long id);
    public void deleteProfile(Long id);
    public List<Profile> listByEmail(String email);
    public List<Profile> listByName(String name);
    public List<Profile> listByAddress(String address);
    public List<Profile> listByPhone(String phone);
}
