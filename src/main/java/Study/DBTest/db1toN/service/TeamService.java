package Study.DBTest.db1toN.service;

import Study.DBTest.db1toN.domain.Team;
import Study.DBTest.db1toN.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public void save(Team team) {
        teamRepository.save(team);
        return;
    }

    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    public Team findById(Long id) {
        return teamRepository.findById(id);
    }

    public Team findByMembername(String membername) {
        return teamRepository.findByMembername(membername);
    }
}
