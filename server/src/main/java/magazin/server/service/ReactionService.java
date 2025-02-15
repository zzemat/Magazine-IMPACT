package magazin.server.service;

import magazin.server.entity.Reaction;

import java.util.List;

public interface ReactionService {
    Reaction createReaction(Reaction reaction);
    Reaction getReactionById(Long id);
    List<Reaction> getAllReactions();
    Reaction updateReaction(Long id, Reaction reaction);
    void deleteReaction(Long id);
}