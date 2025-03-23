package magazin.server.controller;

import magazin.server.dto.PostDTO;
import magazin.server.entity.Post;
import magazin.server.entity.Profile;
import magazin.server.repository.PostRepository;
import magazin.server.service.PostService;
import magazin.server.service.serviceImpl.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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
    @Autowired
    private PostRepository postRepository;

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
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody PostDTO postDTO, @RequestHeader("Authorization") String authorizationHeader) {
        // getting the user details
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            throw new BadCredentialsException("You're unauthorized");
        }
        // getting the post details
        Post post = postService.getPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }

        // checking if the user owns the post
        if (!post.getProfile().getId().equals(userProfile.getId())) {
            throw new BadCredentialsException("You're unauthorized perform do this action");
        }

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setTags(postDTO.getTags());
        postRepository.save(post);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
        // getting the user details
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            throw new BadCredentialsException("You're unauthorized");
        }
//        System.out.println(userProfile);
        // getting the post details
        Post post = postService.getPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }

        // checking if the user owns the post
        // TODO : this needs more testing
        if (!post.getProfile().getId().equals(userProfile.getId()) && !jwtUtils.isAdmin(userProfile)) {
            throw new BadCredentialsException("You're unauthorized perform do this action");
        }

        postRepository.delete(post);
        return ResponseEntity.ok().build();
    }
}