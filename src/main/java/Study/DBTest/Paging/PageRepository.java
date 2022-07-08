package Study.DBTest.Paging;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Content, Long> {

    Page<Content> findAll(Pageable pageable);
    Content findByWriterAndTitle(String writer, String title);
    List<Content> findByWriterContains(String wcontain);
    void deleteById(Long id);
    Content findByWriter(String writer);


}
