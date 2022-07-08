package Study.DBTest.JpaRepositoryTest;

public enum SortTypes {

    No("정렬 안함"),
    AgeDesc("나이 내림차순"),
    AgeAsc("나이 오름차순"),
    RankDesc("랭크 내림차순"),
    RankAsc("랭크 오름차순");

    private final String description;
    SortTypes(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
