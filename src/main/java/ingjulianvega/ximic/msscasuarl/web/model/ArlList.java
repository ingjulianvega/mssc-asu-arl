package ingjulianvega.ximic.msscasuarl.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArlList implements Serializable {

  static final long serialVersionUID = -4521575971603019451L;

  public ArrayList<ArlDto> epsDto;

}

