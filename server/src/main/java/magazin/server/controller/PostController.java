package magazin.server.controller;

import magazin.server.dto.PostDTO;
import magazin.server.entity.Post;
import magazin.server.entity.Profile;
import magazin.server.service.PostService;
import magazin.server.service.serviceImpl.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@Valid @RequestBody PostDTO postDTO, @RequestHeader("Authorization") String authorizationHeader) {
        // TODO: This isn't working for the moment but it can be better
        Post post = new Post(postDTO);
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        post.setProfile(userProfile);
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody Post postDetails) {
        Post updatedPost = postService.updatePost(id, postDetails);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}