package Study.DBTest.JpaRepositoryTest;

import lombok.Data;

@Data
public class SearchForm {

    private Integer ageGe;
    private Integer ageLe;

    private Rank rankGe;
    private Rank rankLe;

    private SortTypes sortType;
}
