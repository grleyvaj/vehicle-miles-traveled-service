package ch.prodigio.vmt.demo.application.controller.vehicle.imports.response;

import ch.prodigio.vmt.demo.application.constant.Documentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Gloria R. Leyva Jerez
 */
@Accessors(chain = true)
@Data
@RequiredArgsConstructor
@Schema(name = "VehicleView", description = Documentation.vehicleRpView_schema_description)
public class VehicleView {

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
}
