package ingjulianvega.ximic.msscasuarl.web.Mappers;

import ingjulianvega.ximic.msscasuarl.domain.ArlEntity;
import ingjulianvega.ximic.msscasuarl.web.model.ArlDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface ArlMapper {
    ArlDto arlEntityToArlDto(ArlEntity arlEntity);

    ArlEntity arlDtoToArlEntity(ArlDto arlDto);

    ArrayList<ArlDto> arlEntityListToArlDtoList(List<ArlEntity> arlEntityList);
}
