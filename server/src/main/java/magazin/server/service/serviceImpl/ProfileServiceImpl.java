package magazin.server.service.serviceImpl;

import magazin.server.entity.Profile;
import magazin.server.repository.ProfileRepository;
import magazin.server.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElse(null);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        if (profileRepository.existsById(id)) {
            profile.setId(id);
            return profileRepository.save(profile);
        }
        return null;
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}