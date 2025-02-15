package magazin.server.service.serviceImpl;

import magazin.server.entity.SavedPost;
import magazin.server.repository.SavedPostRepository;
import magazin.server.service.SavedPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavedPostServiceImpl implements SavedPostService {

    @Autowired
    private SavedPostRepository savedPostRepository;

    @Override
    public SavedPost createSavedPost(SavedPost savedPost) {
        return savedPostRepository.save(savedPost);
    }

    @Override
    public SavedPost getSavedPostById(Long id) {
        Optional<SavedPost> savedPost = savedPostRepository.findById(id);
        return savedPost.orElse(null);
    }

    @Override
    public List<SavedPost> getAllSavedPosts() {
        return savedPostRepository.findAll();
    }

    @Override
    public SavedPost updateSavedPost(Long id, SavedPost savedPost) {
        Optional<SavedPost> existingSavedPostOptional = savedPostRepository.findById(id);
        if (existingSavedPostOptional.isPresent()) {
            SavedPost existingSavedPost = existingSavedPostOptional.get();
            existingSavedPost.setProfile(savedPost.getProfile());
            existingSavedPost.setPost(savedPost.getPost());
            existingSavedPost.setSavedAt(savedPost.getSavedAt());
            return savedPostRepository.save(existingSavedPost);
        } else {
            return null;
        }
    }

    @Override
    public void deleteSavedPost(Long id) {
        savedPostRepository.deleteById(id);
    }
}