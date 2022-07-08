package Study.DBTest.db1toN.repository;

import Study.DBTest.db1toN.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRepository {

    private final EntityManager em;

    public void save(Team team) {
        em.persist(team);
    }

    public Team findByMembername(String membername) {
        return (Team) em.createQuery("select t from Team t join t.members m where m.name=:membername")
                .setParameter("membername", membername)
                .getSingleResult();
    }

    public List<Team> findAll() {
        return em.createQuery("select t from Team t", Team.class)
                .getResultList();
    }

    public Team findById(Long id) {
        return em.find(Team.class, id);
    }
}
