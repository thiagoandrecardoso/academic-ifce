package who.professor.academic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logger;
    private String disdrict;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Student student;
}
