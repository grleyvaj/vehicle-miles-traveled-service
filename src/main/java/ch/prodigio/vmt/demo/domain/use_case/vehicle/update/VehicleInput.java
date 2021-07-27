package ch.prodigio.vmt.demo.domain.use_case.vehicle.update;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Gloria R. Leyva Jerez
 */
@Accessors(chain = true)
@Getter
@Setter
public class VehicleInput {
	private Long id;
	private int countyFips;
	private String countyName;
	private String stateName;
	private String date;
	private Double countyVmt;
	private Double baselineVmt;
	private Double percentChange;
	private Double meanCountyVmt;
	private Double meanPercentChange;
	private String dateAtLow;
	private Double meanCountyVmtAtLow;
	private Double percentChangeFromLow;
}
