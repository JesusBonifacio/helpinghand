package backend.helpinghand.repositories;

import backend.helpinghand.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    public List<Profile> findByEmailContains(String email);

    public List<Profile> findByNameContains(String name);

    public List<Profile> findByAddressContains(String address);

    public List<Profile> findByPhoneContains(String phone);
}
