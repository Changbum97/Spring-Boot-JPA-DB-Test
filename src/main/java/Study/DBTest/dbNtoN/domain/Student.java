package Study.DBTest.dbNtoN.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "student")
    private List<StudentAcademy> studentAcademies = new ArrayList<>();

}
