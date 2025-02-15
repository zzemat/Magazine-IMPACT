package magazin.server.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "profile_picture")
    private String profilePicture;

    @ElementCollection
    @Column(name = "saved_posts")
    private List<Long> savedPosts;

    @ElementCollection
    @Column(name = "followers")
    private List<Long> followers;

    @ElementCollection
    @Column(name = "following")
    private List<Long> following;

    @ElementCollection
    @Column(name = "posts")
    private List<Long> posts;

    @ElementCollection
    @Column(name = "comments")
    private List<Long> comments;

    @ElementCollection
    @Column(name = "reactions")
    private List<Long> reactions;

    @ElementCollection
    @Column(name = "questions")
    private List<Long> questions;

    @ElementCollection
    @Column(name = "answers")
    private List<Long> answers;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}