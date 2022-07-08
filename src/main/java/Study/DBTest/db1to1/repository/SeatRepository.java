package Study.DBTest.db1to1.repository;

import Study.DBTest.db1to1.domain.Customer;
import Study.DBTest.db1to1.domain.Seat;
import Study.DBTest.db1toN.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class SeatRepository {

    private final EntityManager em;

    public void save(Seat seat) {
        em.persist(seat);
    }

    public Seat findById(Long id) {
        return em.find(Seat.class, id);
    }

    public List<Seat> findAll() {
        return em.createQuery("select s from Seat s", Seat.class)
                .getResultList();
    }
}
