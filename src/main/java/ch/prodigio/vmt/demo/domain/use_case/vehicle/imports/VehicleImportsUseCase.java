package ch.prodigio.vmt.demo.domain.use_case.vehicle.imports;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VehicleImportsUseCase {

	private final IVehicleRepository vehicleRepository;

	public Iterable<Vehicle> execute(List<Vehicle> vehiclesImported) {
		vehiclesImported.forEach(this.vehicleRepository::create);
		return vehicleRepository.findAll();
	}
}
