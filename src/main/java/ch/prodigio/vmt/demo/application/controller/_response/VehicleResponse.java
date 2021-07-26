package ch.prodigio.vmt.demo.application.controller._response;

import ch.prodigio.vmt.demo.application.constant.Documentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.hateoas.RepresentationModel;

/**
 * @author Gloria R. Leyva Jerez
 */
@Accessors(chain = true)
@Data
@RequiredArgsConstructor
@Schema(name = "VehicleResponse", description = Documentation.vehicleRp_schema_description)
public class VehicleResponse extends RepresentationModel<VehicleResponse> {

	private static final long serialVersionUID = -8708486773691109649L;

	private long id;

	@JsonProperty(value = "county_fips")
	private int countyFips;

	@JsonProperty(value = "county_name")
	private String countyName;

	@JsonProperty(value = "state_name")
	private String stateName;

	@JsonProperty(value = "date")
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
	private String dateAtLow;

	@JsonProperty(value = "mean7_county_vmt_at_low")
	private Double meanCountyVmtAtLow;

	@JsonProperty(value = "percent_change_from_low")
	private Double percentChangeFromLow;
}
