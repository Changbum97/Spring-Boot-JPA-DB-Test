package Study.DBTest.dbNtoN.repository;

import Study.DBTest.dbNtoN.domain.Academy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@RequiredArgsConstructor
public class AcademyRepository {

    private final EntityManager em;

    public void save(Academy academy) {
        em.persist(academy);
    }

    public Academy findById(Long academyId) {
        return em.find(Academy.class, academyId);
    }
}
