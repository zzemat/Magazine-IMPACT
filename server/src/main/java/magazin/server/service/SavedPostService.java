package magazin.server.service;

import magazin.server.entity.SavedPost;

import java.util.List;

public interface SavedPostService {
    SavedPost createSavedPost(SavedPost savedPost);
    SavedPost getSavedPostById(Long id);
    List<SavedPost> getAllSavedPosts();
    SavedPost updateSavedPost(Long id, SavedPost savedPost);
    void deleteSavedPost(Long id);
}