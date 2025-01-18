package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "task_id")
    private Long taskId;
    @Size(min = 2, max = 250, message = "Description needs to be between 2-250 characters.")
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private Set<PersonTask> personTasks = new HashSet<>();


}
