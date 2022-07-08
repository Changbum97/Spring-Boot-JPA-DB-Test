package Study.DBTest.JpaRepositoryTest;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    private String name;
    private Integer age;
    private Rank rank;

}
