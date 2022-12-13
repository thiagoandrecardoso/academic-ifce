package who.professor.academic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class MC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int cod;

    @ManyToMany
    private List<Discipline> disciplines;

    @ManyToOne
    private Course course;
}
