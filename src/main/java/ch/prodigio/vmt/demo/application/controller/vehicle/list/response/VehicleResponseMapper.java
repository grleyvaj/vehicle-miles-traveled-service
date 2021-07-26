package ch.prodigio.vmt.demo.application.controller.vehicle.list.response;

import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.application.controller._response.VehicleResponse;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;

public class VehicleResponseMapper implements Mapper<Vehicle, VehicleResponse> {

	@Override
	public VehicleResponse map(Vehicle vehicle) {
		return new VehicleResponse()
			.setId(vehicle.getId())
			.setCountyFips(vehicle.getCountyFips())
			.setCountyName(vehicle.getCountyName())
			.setStateName(vehicle.getStateName())
			.setDate(String.valueOf(vehicle.getDate()))
			.setCountyVmt(vehicle.getCountyVmt())
			.setBaselineVmt(vehicle.getBaselineVmt())
			.setPercentChange(vehicle.getPercentChange())
			.setMeanCountyVmt(vehicle.getMeanCountyVmt())
			.setMeanPercentChange(vehicle.getMeanPercentChange())
			.setDateAtLow(String.valueOf(vehicle.getDateAtLow()))
			.setMeanCountyVmtAtLow(vehicle.getMeanCountyVmtAtLow())
			.setPercentChangeFromLow(vehicle.getPercentChangeFromLow()
			);
	}
}
