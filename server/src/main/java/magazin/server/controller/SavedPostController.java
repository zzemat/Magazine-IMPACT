package magazin.server.controller;

import magazin.server.entity.SavedPost;
import magazin.server.service.SavedPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/saved-posts")
public class SavedPostController {

    @Autowired
    private SavedPostService savedPostService;

    @GetMapping
    public List<SavedPost> getAllSavedPosts() {
        return savedPostService.getAllSavedPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavedPost> getSavedPostById(@PathVariable Long id) {
        SavedPost savedPost = savedPostService.getSavedPostById(id);
        if (savedPost != null) {
            return ResponseEntity.ok(savedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public SavedPost createSavedPost(@RequestBody SavedPost savedPost) {
        return savedPostService.createSavedPost(savedPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavedPost> updateSavedPost(@PathVariable Long id, @RequestBody SavedPost savedPost) {
        SavedPost updatedSavedPost = savedPostService.updateSavedPost(id, savedPost);
        if (updatedSavedPost != null) {
            return ResponseEntity.ok(updatedSavedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavedPost(@PathVariable Long id) {
        savedPostService.deleteSavedPost(id);
        return ResponseEntity.noContent().build();
    }
}