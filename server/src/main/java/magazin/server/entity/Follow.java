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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @NotNull
    @Column(name = "user_src_id")
    private Long userSrcId;

    @NotNull
    @Column(name = "user_trg_id")
    private Long userTrgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_src_id", insertable = false, updatable = false)
    private User userSrc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_trg_id", insertable = false, updatable = false)
    private User userTrg;
    
}