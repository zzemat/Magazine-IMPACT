package magazin.server.service.serviceImpl;

import magazin.server.entity.Reaction;
import magazin.server.repository.ReactionRepository;
import magazin.server.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public Reaction createReaction(Reaction reaction) {
        return reactionRepository.save(reaction);
    }

    @Override
    public Reaction getReactionById(Long id) {
        Optional<Reaction> reaction = reactionRepository.findById(id);
        return reaction.orElse(null); // or throw an exception if preferred
    }

    @Override
    public List<Reaction> getAllReactions() {
        return reactionRepository.findAll();
    }

    @Override
    public Reaction updateReaction(Long id, Reaction reaction) {
        if (reactionRepository.existsById(id)) {
            reaction.setId(id);
            return reactionRepository.save(reaction);
        }
        return null; // or throw an exception if preferred
    }

    @Override
    public void deleteReaction(Long id) {
        reactionRepository.deleteById(id);
    }
}