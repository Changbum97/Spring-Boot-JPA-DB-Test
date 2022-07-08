package Study.DBTest.dbCRUD.repository;

import Study.DBTest.dbCRUD.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public void remove(Long id) {
        em.remove(findById(id));
        return;
    }

    public User findByName(String findName) {
        return em.createQuery("select u from User u where u.name = :findName", User.class)
                .setParameter("findName", findName)
                .getSingleResult();

    }

    public List<User> findAll() {
        // JPQL Java Persistence Query Language 대소문자 구분
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
}
