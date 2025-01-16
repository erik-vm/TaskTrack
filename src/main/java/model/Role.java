package model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    @Column(name = "role_name")
    String roleName;
    String description;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<Person> people = new HashSet<>();
}