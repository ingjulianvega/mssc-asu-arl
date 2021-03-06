package ingjulianvega.ximic.msscasuarl.services;


import ingjulianvega.ximic.msscasuarl.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuarl.domain.ArlEntity;
import ingjulianvega.ximic.msscasuarl.domain.repositories.ArlRepository;
import ingjulianvega.ximic.msscasuarl.exception.ArlException;
import ingjulianvega.ximic.msscasuarl.web.Mappers.ArlMapper;
import ingjulianvega.ximic.msscasuarl.web.model.Arl;
import ingjulianvega.ximic.msscasuarl.web.model.ArlDto;
import ingjulianvega.ximic.msscasuarl.web.model.ArlList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ArlServiceImpl implements ArlService {

    private final ArlRepository arlRepository;
    private final ArlMapper arlMapper;

    @Cacheable(cacheNames = "arlListCache", condition = "#usingCache == false")
    @Override
    public ArlList get(Boolean usingCache) {
        log.debug("get()...");
        return ArlList
                .builder()
                .epsDto(arlMapper.arlEntityListToArlDtoList(arlRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "arlCache")
    @Override
    public ArlDto getById(UUID id) {
        log.debug("getById()...");
        return arlMapper.arlEntityToArlDto(
                arlRepository.findById(id).orElseThrow(() -> ArlException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.ARL_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.ARL_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.ARL_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.ARL_NOT_FOUND_SOLUTION)
                        .build()));
    }

    @Override
    public void create(Arl arl) {
        log.debug("create()...");
        arlMapper.arlEntityToArlDto(
                arlRepository.save(
                        arlMapper.arlDtoToArlEntity(
                                ArlDto
                                        .builder()
                                        .name(arl.getName()).
                                        build())));
    }

    @Override
    public void updateById(UUID id, Arl arl) {
        log.debug("updateById...");
        ArlEntity arlEntity = arlRepository.findById(id).orElseThrow(() -> ArlException
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .apiCode(ErrorCodeMessages.ARL_NOT_FOUND_API_CODE)
                .error(ErrorCodeMessages.ARL_NOT_FOUND_ERROR)
                .message(ErrorCodeMessages.ARL_NOT_FOUND_MESSAGE)
                .solution(ErrorCodeMessages.ARL_NOT_FOUND_SOLUTION)
                .build());
        arlEntity.setName(arl.getName());

        arlRepository.save(arlEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        arlRepository.deleteById(id);
    }
}
