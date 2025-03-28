package magazin.server.repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import magazin.server.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    Optional<List<Post>> findAllByTitle(String title);

    @Query("SELECT p FROM Post p WHERE " +
            "LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%')) " +
            "AND EXISTS (SELECT t FROM Post p2 JOIN p2.tags t WHERE LOWER(t) IN :tags AND p2.id = p.id)")
    Optional<List<Post>> findAllByTitleAndTags(@NotBlank @Size(max = 255) String title, List<String> tags);

    @Query("SELECT p FROM Post p WHERE p.published = true ORDER BY p.createdAt LIMIT 20 OFFSET :page")
    List<Post> getPage(int page);
}