package magazin.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import magazin.server.DTO.PostDTO;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonIgnore
    private Profile profile;

    @Column(name = "banner_img")
    private String bannerImg;

    @NotBlank
    @Size(max = 255)
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @ElementCollection(fetch = FetchType.LAZY)
    @Column(name = "tags")
    private List<String> tags = new ArrayList<>();;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reaction> reactions = new ArrayList<>();

    @Transient
    public int getReactionCount() {
        return reactions != null ? reactions.size() : 0;
    }

    @NotNull
    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Column(name = "published_at")
    @CreationTimestamp
    private LocalDateTime createdAt;


    public Post(PostDTO postDTO) {
        setTitle(postDTO.getTitle());
        setContent(postDTO.getContent());
        setTags(postDTO.getTags());
    }
}