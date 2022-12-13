package who.professor.academic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double score;

    private int cod;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;

    @ManyToMany(mappedBy = "disciplines")
    private List<MC> curriculumList;

    @ManyToMany(mappedBy = "disciplines")
    private List<Teacher> teachers;

}
