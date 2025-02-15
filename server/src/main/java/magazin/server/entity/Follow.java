package magazin.server.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "follows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Follow {

    @EmbeddedId
    private FollowId id;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FollowId implements java.io.Serializable {
        @NotNull
        @Column(name = "user_src_id")
        private Long userSrcId;

        @NotNull
        @Column(name = "user_trg_id")
        private Long userTrgId;
    }
}