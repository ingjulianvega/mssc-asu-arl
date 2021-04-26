package ingjulianvega.ximic.msscasuarl.bootstrap;

import ingjulianvega.ximic.msscasuarl.domain.ArlEntity;
import ingjulianvega.ximic.msscasuarl.domain.repositories.ArlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class ArlLoader implements CommandLineRunner {

    private final ArlRepository arlRepository;

    @Override
    public void run(String... args) throws Exception {
        if (arlRepository.count() == 0) {
            loadArlObjects();
        }
    }

    private void loadArlObjects() {
        arlRepository.saveAll(Arrays.asList(
                ArlEntity.builder().name("SURA").build(),
                ArlEntity.builder().name("POSITIVA").build(),
                ArlEntity.builder().name("NINGUNA").build(),
                ArlEntity.builder().name("COLPATRIA").build()
        ));
    }
}
