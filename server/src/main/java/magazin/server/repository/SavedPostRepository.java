package magazin.server.repository;

import magazin.server.entity.SavedPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedPostRepository extends JpaRepository<SavedPost, Long> {
}