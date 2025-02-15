package magazin.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
//import java.util.List;

@Entity
@Table(name = "answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @NotBlank
    @Column(name = "text", nullable = false)
    private String text;

    /* 
    @ManyToMany
    @JoinTable(
        name = "answer_reactions",
        joinColumns = @JoinColumn(name = "answer_id"),
        inverseJoinColumns = @JoinColumn(name = "reaction_id")
)
    private List<Reaction> reactions;
    */
    @NotNull
    @Column(name = "published_at", nullable = false)
    private LocalDateTime publishedAt;
}