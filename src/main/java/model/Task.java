package model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;
    private String description;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private Set<PersonTask> personTasks = new HashSet<>();


}
