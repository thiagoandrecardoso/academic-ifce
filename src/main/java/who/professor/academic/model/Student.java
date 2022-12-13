package who.professor.academic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String password;

    private Boolean status;

    private Long rating;

    private double score;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Temporal(TemporalType.DATE)
    private Calendar dtNascimento;

    private String phone;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private List<Discipline> disciplines;

}
