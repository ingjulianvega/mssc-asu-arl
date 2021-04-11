package ingjulianvega.ximic.msscasuarl.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.UUID;

import static ingjulianvega.ximic.msscasuarl.configuration.ErrorCodeMessages.VALIDATION_NAME_NULL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArlDto implements Serializable {
    static final long serialVersionUID = 8217497793616312861L;

    @Null
    private UUID id;
    @NotBlank(message = VALIDATION_NAME_NULL)
    private String name;

}

