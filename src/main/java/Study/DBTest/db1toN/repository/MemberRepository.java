package Study.DBTest.db1toN.repository;

import Study.DBTest.db1toN.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findByTeamname(String teamname) {
       return em.createQuery("select m from Customer m join m.team t where t.name=:teamname")
               .setParameter("teamname", teamname)
               .getResultList();
    }

    public Member findById(Long memberId){
        return em.find(Member.class, memberId);
    }
}
