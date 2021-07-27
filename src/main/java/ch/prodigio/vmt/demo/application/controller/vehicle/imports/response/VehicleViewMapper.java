package ch.prodigio.vmt.demo.application.controller.vehicle.imports.response;

import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;

public class VehicleViewMapper implements Mapper<Vehicle, VehicleView> {

	@Override
	public VehicleView map(Vehicle vehicle) {
		return new VehicleView()
			.setId(vehicle.getId())
			.setCountyFips(vehicle.getCountyFips())
			.setCountyName(vehicle.getCountyName())
			.setStateName(vehicle.getStateName())
			.setDate(String.valueOf(vehicle.getDate()));
	}
}
