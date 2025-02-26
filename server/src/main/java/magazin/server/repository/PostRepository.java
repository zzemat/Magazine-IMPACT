package magazin.server.repository;

import magazin.server.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select posts from Post posts where posts.title like %?1%")
    Optional<List<Post>> findAllByTitle(String title);
}