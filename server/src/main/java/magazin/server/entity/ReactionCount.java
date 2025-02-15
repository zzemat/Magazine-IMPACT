package magazin.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

// if we decide to add more types of reactions !!!!!!!!!!!! author: @Idir0u

@Entity
@Table(name = "reaction_counts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReactionCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "reaction_id", nullable = false)
    private Reaction reaction;

    @NotNull
    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @NotNull
    @Column(name = "entity_type", nullable = false)
    private String entityType;

    @NotNull
    @Column(name = "count", nullable = false)
    private Integer count;
}
