package magazin.server.repository;

import magazin.server.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    @Query("SELECT r FROM Reaction r WHERE r.post.id = :postId AND r.profile.id = :profileId")
    Optional<Reaction> findReactionByPostIdAndProfileId(Long postId, Long profileId);
}