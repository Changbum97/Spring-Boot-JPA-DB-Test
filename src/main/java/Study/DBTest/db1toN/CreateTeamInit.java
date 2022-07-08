package Study.DBTest.db1toN;

import Study.DBTest.db1toN.domain.Team;
import Study.DBTest.db1toN.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CreateTeamInit {

    private final TeamService teamService;

    @PostConstruct
    public void init() {
        Team team1 = new Team();
        team1.setName("팀 1");
        teamService.save(team1);

        Team team2 = new Team();
        team2.setName("팀 2");
        teamService.save(team2);

        Team team3 = new Team();
        team3.setName("팀 3");
        teamService.save(team3);
    }
}
