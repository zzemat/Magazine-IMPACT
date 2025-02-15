package magazin.server.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}