package magazin.server.controller;

import magazin.server.entity.SavedPost;
import magazin.server.service.SavedPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/v1/api/saved-posts")
public class SavedPostController {

    @Autowired
    private SavedPostService savedPostService;

    @GetMapping("/all")
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

    @PostMapping("/create")
    public ResponseEntity<SavedPost> createSavedPost(@Valid @RequestBody SavedPost savedPost) {
        SavedPost createdSavedPost = savedPostService.createSavedPost(savedPost);
        return ResponseEntity.ok(createdSavedPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavedPost> updateSavedPost(@PathVariable Long id,@Valid @RequestBody SavedPost savedPost) {
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