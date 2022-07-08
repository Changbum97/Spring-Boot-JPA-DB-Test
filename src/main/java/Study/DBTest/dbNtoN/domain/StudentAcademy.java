package Study.DBTest.dbNtoN.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class StudentAcademy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_academy_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_id")
    private Academy academy;

    private LocalDateTime registerDate;

    public void setStudent(Student student) {
        this.student = student;
        student.getStudentAcademies().add(this);
    }
    public void setAcademy(Academy academy) {
        this.academy = academy;
        academy.getStudentAcademies().add(this);
    }
}
