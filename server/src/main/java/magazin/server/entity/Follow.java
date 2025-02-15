package magazin.server.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "follows")
@Data
public class Follow {
    @Id
    private Long userSrcId;
    @Id
    private Long userTrgId;
}