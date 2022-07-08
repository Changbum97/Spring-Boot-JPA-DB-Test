package Study.DBTest.db1toN.service;

import Study.DBTest.db1toN.domain.Member;
import Study.DBTest.db1toN.repository.MemberRepository;
import Study.DBTest.db1toN.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public void save(Member member, Long teamId) {
        member.setTeam(teamRepository.findById(teamId));
        memberRepository.save(member);
        return;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
    public List<Member> findByTeamname(String teamname) {
        return memberRepository.findByTeamname(teamname);
    }

    public void removeTeam(Long memberId) {
        Member member = memberRepository.findById(memberId);
        //member.setTeam(teamRepository.findById(2L));
        member.setTeam(null);
        return;
    }
}
