package magazin.server.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "answers")
@Data
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToMany
    @JoinTable(
        name = "answer_reactions",
        joinColumns = @JoinColumn(name = "answer_id"),
        inverseJoinColumns = @JoinColumn(name = "reaction_id")
    )
    private List<Reaction> reactions;

    @Column(name = "published_at", nullable = false)
    private LocalDateTime publishedAt;
}