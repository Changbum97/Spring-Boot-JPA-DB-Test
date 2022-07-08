package Study.DBTest.dbNtoN.repository;

import Study.DBTest.dbNtoN.domain.Academy;
import Study.DBTest.dbNtoN.domain.Student;
import Study.DBTest.dbNtoN.domain.StudentAcademy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class StudentRepository {

    private final EntityManager em;

    public void save(Student student) {
        em.persist(student);
    }

    public Student findById(Long studentId) {
        return em.find(Student.class, studentId);
    }

    public void registerAcademy(StudentAcademy studentAcademy) {
        em.persist(studentAcademy);
    }

    public List<StudentAcademy> showAll() {
        return em.createQuery("select sa from StudentAcademy sa",StudentAcademy.class)
                .getResultList();
    }
}
