package magazin.server.service;

import magazin.server.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile profile);
    Profile getProfileById(Long id);
    List<Profile> getAllProfiles();
    Profile updateProfile(Long id, Profile profile);
    void deleteProfile(Long id);
}