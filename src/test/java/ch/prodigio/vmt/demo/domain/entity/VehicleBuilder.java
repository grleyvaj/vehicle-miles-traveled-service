package ch.prodigio.vmt.demo.domain.entity;

import ch.prodigio.vmt.demo.application.builder.Builder;

import java.time.LocalDate;

public class VehicleBuilder extends Builder<Vehicle> {

	@Override
	public Vehicle build(int index) {
		return new Vehicle()
			.setId((long)index)
			.setCountyFips(1001)
			.setCountyName("Autauga")
			.setStateName("Alabama")
			.setDate(LocalDate.parse("2020-05-08"))
			.setCountyVmt(3550000.0)
			.setBaselineVmt(3571446.0)
			.setPercentChange(-0.6)
			.setMeanCountyVmt(2790000.0)
			.setMeanPercentChange(-21.88)
			.setDateAtLow(LocalDate.parse("2020-04-12"))
			.setMeanCountyVmtAtLow(1542857.14)
			.setPercentChangeFromLow(80.83);
	}

}
