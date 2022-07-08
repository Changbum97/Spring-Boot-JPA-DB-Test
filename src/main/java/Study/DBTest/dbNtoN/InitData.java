package Study.DBTest.dbNtoN;

import Study.DBTest.dbNtoN.domain.Academy;
import Study.DBTest.dbNtoN.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {
    private final AcademyRepository academyRepository;

    @PostConstruct
    public void init() {
        Academy academy1 = new Academy();
        academy1.setName("수학학원");
        academyRepository.save(academy1);

        Academy academy2 = new Academy();
        academy2.setName("영어학원");
        academyRepository.save(academy2);


        Academy academy3 = new Academy();
        academy3.setName("국어학원");
        academyRepository.save(academy3);
    }
}
