package ch.prodigio.vmt.demo.application.controller.vehicle.create.request;

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
public class VehicleRequest implements Serializable {

	private static final long serialVersionUID = -8708486773692909649L;

	private Long id;

	@JsonProperty(value = "county_fips")
	@Min(value = 1, message = "{min.countyFips}")
	private int countyFips;

	@JsonProperty(value = "county_name")
	@NotBlank(message = "{notBlank.countyName}")
	private String countyName;

	@JsonProperty(value = "state_name")
	@NotBlank(message = "{notBlank.stateName}")
	private String stateName;

	@JsonProperty(value = "date")
	@NotBlank(message = "{notBlank.date}")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "{pattern.date}")
	private String date;

	@JsonProperty(value = "county_vmt")
	private Double countyVmt;

	@JsonProperty(value = "baseline_jan_vmt")
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
