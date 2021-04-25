package ingjulianvega.ximic.msscasuarl.domain.repositories;


import ingjulianvega.ximic.msscasuarl.domain.ArlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface ArlRepository extends JpaRepository<ArlEntity, UUID>, JpaSpecificationExecutor<ArlEntity> {
    List<ArlEntity> findAllByOrderByName();
}
