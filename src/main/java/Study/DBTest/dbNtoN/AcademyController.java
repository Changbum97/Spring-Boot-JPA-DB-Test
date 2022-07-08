package Study.DBTest.dbNtoN;

import Study.DBTest.dbNtoN.domain.*;
import Study.DBTest.dbNtoN.repository.AcademyRepository;
import Study.DBTest.dbNtoN.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AcademyController {

    private final StudentRepository studentRepository;
    private final AcademyRepository academyRepository;

    @GetMapping("/academy/add")
    public String addAcademy(@RequestParam String name) {
        Academy academy = new Academy();
        academy.setName(name);
        academyRepository.save(academy);
        return "complete";
    }

    @GetMapping("/academy/{academyId}/show")
    public AcademyDto showAcademy(@PathVariable Long academyId) {
        AcademyDto academyDto = new AcademyDto(academyRepository.findById(academyId));
        return academyDto;
    }

    @GetMapping("/student/add")
    public String addStudent(@RequestParam String name, int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentRepository.save(student);
        return "complete";
    }

    @GetMapping("/student/{studentId}/show")
    public StudentDto showStudent(@PathVariable Long studentId) {
        StudentDto studentDto = new StudentDto(studentRepository.findById(studentId));
        return studentDto;
    }

    @GetMapping("/register")
    public String registerAcademy(@RequestParam Long studentId, Long academyId) {
        StudentAcademy studentAcademy = new StudentAcademy();
        studentAcademy.setStudent(studentRepository.findById(studentId));
        studentAcademy.setAcademy(academyRepository.findById(academyId));
        studentAcademy.setRegisterDate(LocalDateTime.now());
        studentRepository.registerAcademy(studentAcademy);
        return "complete";
    }

    // 참조 순환 해결 X
    @GetMapping("/showAllStudenAcademy")
    public List<StudentAcademy> showAll() {
        return studentRepository.showAll();
    }
}
