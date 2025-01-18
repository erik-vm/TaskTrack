package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long person_id;

    @NotNull
    @Size(min = 1, max = 50, message = "First name must be between 1-50 characters!")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50, message = "Last name must be between 1-50 characters!")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Email cant be empty!")
    @Email(message = "Email should be valid!")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @OneToOne(mappedBy = "person", cascade = ALL)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "person", cascade = ALL, fetch = EAGER)
    private Set<PersonRole> personRoles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "person", cascade = ALL, fetch = EAGER)
    private Set<PersonTask> personTasks = new HashSet<>();

    @JsonIgnore
    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    @JsonIgnore
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
