package Study.DBTest.Paging;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    private String title;
    private String writer;
}
