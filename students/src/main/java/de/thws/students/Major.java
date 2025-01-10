package de.thws.students;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * de: Studiengang
 */
@Entity
public class Major {

    @Id
    @GeneratedValue
    public Long id;

    @NotBlank
    @NotNull
    public String name;

    @OneToMany(mappedBy = "major")
    public List<Student> students;

}
