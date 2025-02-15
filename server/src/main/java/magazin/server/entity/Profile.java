package magazin.server.entity;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Size(max = 255)
    @Column(name = "profile_picture")
    private String profilePicture;

    @ElementCollection
    @NotEmpty
    @Column(name = "saved_posts")
    private List<Long> savedPosts;

    @ManyToMany
    @JoinTable(
        name = "follows",
        joinColumns = @JoinColumn(name = "user_src_id"),
        inverseJoinColumns = @JoinColumn(name = "user_trg_id")
    )
    private Set<Profile> followers;

    @ManyToMany(mappedBy = "followers")
    private Set<Profile> following;

    @ElementCollection
    @NotEmpty
    @Column(name = "posts")
    private List<Long> posts;

    @ElementCollection
    @NotEmpty
    @Column(name = "comments")
    private List<Long> comments;

    @ElementCollection
    @NotEmpty
    @Column(name = "reactions")
    private List<Long> reactions;

    @ElementCollection
    @NotEmpty
    @Column(name = "questions")
    private List<Long> questions;

    @ElementCollection
    @NotEmpty
    @Column(name = "answers")
    private List<Long> answers;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}