package magazin.server.controller;

import magazin.server.DTO.ReactionDTO;
import magazin.server.entity.Post;
import magazin.server.entity.Profile;
import magazin.server.entity.Reaction;
import magazin.server.repository.PostRepository;
import magazin.server.repository.ReactionRepository;
import magazin.server.service.ReactionService;
import magazin.server.service.serviceImpl.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/reactions")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    private final JwtUtils jwtUtils;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ReactionRepository reactionRepository;

    public ReactionController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("/all")
    public List<Reaction> getAllReactions() {
        return reactionService.getAllReactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reaction> getReactionById(@PathVariable Long id) {
        Reaction reaction = reactionService.getReactionById(id);
        if (reaction != null) {
            return ResponseEntity.ok(reaction);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Reaction> createReaction(@RequestBody @Valid ReactionDTO reactionDTO, @RequestHeader("Authorization") String authorizationHeader) {
        // getting the user details
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            throw new BadCredentialsException("You're unauthorized");
        }

        // getting the post
        Optional<Post> post = postRepository.findById(reactionDTO.getPostId());
        if (post.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // checking if such reaction already exists
        Optional<Reaction> reaction = reactionRepository.findReactionByPostIdAndProfileId(post.get().getId(), userProfile.getId());
        if (reaction.isPresent()) {
            System.out.println(reaction.get());
            return ResponseEntity.status(403).build();
        }

        Reaction createdReaction = new Reaction();
        createdReaction.setReactionType(reactionDTO.getReactionType());
        createdReaction.setProfile(userProfile);
        createdReaction.setPost(post.get());
        reactionRepository.save(createdReaction);
        return ResponseEntity.ok(createdReaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reaction> updateReaction(@PathVariable Long id, @RequestBody @Valid ReactionDTO reactionDTO, @RequestHeader("Authorization") String authorizationHeader) {
        // getting the user details
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            throw new BadCredentialsException("You're unauthorized");
        }

        // getting the reaction
        Optional<Reaction> reaction = reactionRepository.findById(id);
        if (reaction.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // checking if the user owns the reaction
        Reaction newReaction = reaction.get();
        if (newReaction.getProfile().getId().equals(userProfile.getId())) {
            return ResponseEntity.status(403).build();
        }

        newReaction.setReactionType(reactionDTO.getReactionType());
        reactionRepository.save(newReaction);
        return ResponseEntity.ok(newReaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
        // getting the user details
        Profile userProfile = jwtUtils.getProfile(authorizationHeader);
        if (userProfile == null) {
            throw new BadCredentialsException("You're unauthorized");
        }

        // getting the reaction
        Optional<Reaction> reaction = reactionRepository.findById(id);
        if (reaction.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // checking if the user owns the reaction
        Reaction newReaction = reaction.get();
        if (newReaction.getProfile().getId().equals(userProfile.getId())) {
            return ResponseEntity.status(403).build();
        }

        reactionRepository.delete(newReaction);
        return ResponseEntity.ok().build();
    }
}