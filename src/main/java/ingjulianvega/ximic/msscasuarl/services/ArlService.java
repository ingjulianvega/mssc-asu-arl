package ingjulianvega.ximic.msscasuarl.services;

import ingjulianvega.ximic.msscasuarl.web.model.Arl;
import ingjulianvega.ximic.msscasuarl.web.model.ArlDto;
import ingjulianvega.ximic.msscasuarl.web.model.ArlList;

import java.util.UUID;

public interface ArlService {
    ArlList get();

    ArlDto getById(UUID id);

    void create(Arl arl);

    void updateById(UUID id, Arl arl);

    void deleteById(UUID id);
}
