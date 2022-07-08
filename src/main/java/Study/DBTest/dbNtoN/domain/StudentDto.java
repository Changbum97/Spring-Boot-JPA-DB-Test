package Study.DBTest.dbNtoN.domain;

import Study.DBTest.db1to1.domain.Seat;
import lombok.Data;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private int age;
    private int academyCount;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
        this.academyCount = student.getStudentAcademies().size();
    }
}
