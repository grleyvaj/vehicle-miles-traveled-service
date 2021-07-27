package ch.prodigio.vmt.demo.domain.use_case.vehicle.update;

import ch.prodigio.vmt.demo.application.constant.Documentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author Gloria R. Leyva Jerez
 */
@Accessors(chain = true)
@Data
@Schema(name = "VehicleRequest", description = Documentation.vehicleRq_schema_description)
public class VehicleInput implements Serializable {

	private static final long serialVersionUID = -8708486773692909649L;

	private Long id;
	private int countyFips;
	private String countyName;
	private String stateName;
	private String date;
	private Double countyVmt;
	private Double baselineVmt;

	@JsonProperty(value = "percent_change_from_jan")
	private Double percentChange;

	@JsonProperty(value = "mean7_county_vmt")
	private Double meanCountyVmt;

	@JsonProperty(value = "mean7_percent_change_from_jan")
	private Double meanPercentChange;

	@JsonProperty(value = "date_at_low")
	@NotBlank(message = "{notBlank.dateAtLow}")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "{pattern.date}")
	private String dateAtLow;

	@JsonProperty(value = "mean7_county_vmt_at_low")
	private Double meanCountyVmtAtLow;

	@JsonProperty(value = "percent_change_from_low")
	private Double percentChangeFromLow;
}
