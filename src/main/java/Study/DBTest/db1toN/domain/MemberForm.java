package Study.DBTest.db1toN.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberForm {

    @NotEmpty(message = "이름은 필수입니다!")
    private String name;

    @NotNull(message = "나이는 필수입니다!")
    private int age;

    @NotNull(message = "팀은 필수입니다!")
    private Long teamId;
}
