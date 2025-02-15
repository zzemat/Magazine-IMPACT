package magazin.server.controller;

import magazin.server.entity.Reaction;
import magazin.server.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/v1/api/reactions")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @GetMapping
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

    @PostMapping
    public Reaction createReaction(@Valid @RequestBody Reaction reaction) {
        return reactionService.createReaction(reaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reaction> updateReaction(@PathVariable Long id,@Valid @RequestBody Reaction reaction) {
        Reaction updatedReaction = reactionService.updateReaction(id, reaction);
        if (updatedReaction != null) {
            return ResponseEntity.ok(updatedReaction);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long id) {
        reactionService.deleteReaction(id);
        return ResponseEntity.noContent().build();
    }
}