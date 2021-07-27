package ch.prodigio.vmt.demo.domain.use_case.vehicle.create;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VehicleCreateUseCase {

	private final IVehicleRepository repository;

	public Vehicle execute(Vehicle vehicle) {
		return this.repository.create(vehicle);
	}
}
