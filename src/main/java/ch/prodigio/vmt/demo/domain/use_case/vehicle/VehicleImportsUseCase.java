package ch.prodigio.vmt.demo.domain.use_case.vehicle;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VehicleImportsUseCase {

	private final IVehicleRepository vehicleRepository;

	public void execute(List<Vehicle> vehiclesImported) {
		vehiclesImported.stream().forEach(this.vehicleRepository::create);
	}
}
