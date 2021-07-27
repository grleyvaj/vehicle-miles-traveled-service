package ch.prodigio.vmt.demo.application.controller.vehicle.create.request;

import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;

import java.time.LocalDate;

public class VehicleRequestMapper implements Mapper<VehicleRequest, Vehicle> {

	@Override
	public Vehicle map(VehicleRequest request) {
		return new Vehicle()
			.setId(request.getId())
			.setCountyFips(request.getCountyFips())
			.setCountyName(request.getCountyName())
			.setStateName(request.getStateName())
			.setDate(LocalDate.parse(request.getDate()))
			.setCountyVmt(request.getCountyVmt())
			.setBaselineVmt(request.getBaselineVmt())
			.setPercentChange(request.getPercentChange())
			.setMeanCountyVmt(request.getMeanCountyVmt())
			.setMeanPercentChange(request.getMeanPercentChange())
			.setDateAtLow(LocalDate.parse(request.getDateAtLow()))
			.setMeanCountyVmtAtLow(request.getMeanCountyVmtAtLow())
			.setPercentChangeFromLow(request.getPercentChangeFromLow()
			);
	}
}
