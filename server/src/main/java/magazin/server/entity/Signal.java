package magazin.server.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@Table(name = "signals")
@AllArgsConstructor
@NoArgsConstructor
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "ref_id")
    private String refId;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotBlank
    @Column(name = "contenue", columnDefinition = "TEXT")
    private String contenue;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @NotNull
    @Column(name = "pushed_at")
    @CreationTimestamp
    private LocalDate createdAt;
}
