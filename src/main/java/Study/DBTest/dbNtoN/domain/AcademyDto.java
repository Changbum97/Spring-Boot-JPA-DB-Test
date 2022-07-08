package Study.DBTest.dbNtoN.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AcademyDto {
    private Long id;
    private String name;
    //private List<String> studentNameList = new ArrayList<>();
    private Map<String, LocalDateTime> studentInfo = new HashMap<>();

    public AcademyDto(Academy academy) {
        this.id = academy.getId();
        this.name = academy.getName();
        for(StudentAcademy studentAcademy : academy.getStudentAcademies()) {
            studentInfo.put(studentAcademy.getStudent().getName(), studentAcademy.getRegisterDate());
        }
    }
}
