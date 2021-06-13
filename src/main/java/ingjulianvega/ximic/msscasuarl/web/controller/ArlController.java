package ingjulianvega.ximic.msscasuarl.web.controller;

import ingjulianvega.ximic.msscasuarl.services.ArlService;
import ingjulianvega.ximic.msscasuarl.web.model.Arl;
import ingjulianvega.ximic.msscasuarl.web.model.ArlDto;
import ingjulianvega.ximic.msscasuarl.web.model.ArlList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ArlController implements ArlI {
    private final ArlService arlService;

    @Override
    public ResponseEntity<ArlList> get(Boolean usingCache) {
        return new ResponseEntity<>(arlService.get(usingCache), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArlDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(arlService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Arl arl) {
        arlService.create(arl);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Arl arl) {
        arlService.updateById(id, arl);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        arlService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}