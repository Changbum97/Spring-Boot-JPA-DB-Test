package Study.DBTest.db1toN.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;
    private int age;

    // 연관관계 매핑 mappedby 반대쪽이 주인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    // 연관관계 편의 메서드
    public void setTeam(Team team) {
        if(team == null) {
            this.team.getMembers().remove(this);
        } else {
            team.getMembers().add(this);
        }
        this.team = team;
        // team.getMembers().add(this);
    }
}
