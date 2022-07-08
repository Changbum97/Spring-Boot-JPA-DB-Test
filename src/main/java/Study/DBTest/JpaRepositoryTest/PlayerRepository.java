package Study.DBTest.JpaRepositoryTest;

import Study.DBTest.Paging.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Page<Player> findAll(Pageable pageable);
    Player findByName(String name);
    Page<Player> findByAgeGreaterThanEqualAndAgeLessThanEqualAndRankGreaterThanEqualAndRankLessThanEqual(
            Integer AgeGe, Integer AgeLe, Rank RankGe, Rank RankLe, Pageable pageable);
 }
