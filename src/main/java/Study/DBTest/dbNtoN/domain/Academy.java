package Study.DBTest.dbNtoN.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academy_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "academy")
    private List<StudentAcademy> studentAcademies = new ArrayList<>();
}
