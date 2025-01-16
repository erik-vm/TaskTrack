package model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;
    private String description;
    private TaskStatus status;

    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
    private Set<Person> people = new HashSet<>();


}
