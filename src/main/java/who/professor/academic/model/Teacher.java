package who.professor.academic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Teacher {

    public Teacher() {
        this.disciplines = new ArrayList<>();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Transient
    private String codDisciplines;

    @ManyToMany
    private List<Discipline> disciplines;
}
