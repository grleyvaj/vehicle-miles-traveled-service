package ch.prodigio.vmt.demo.domain.use_case.vehicle;

import ch.prodigio.vmt.demo.application.constant.URIConstant;
import ch.prodigio.vmt.demo.application.exception.ResourceNotFoundException;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VehicleFindUseCase {

	private static final String VEHICLE = URIConstant.ENTITY_VEHICLE;

	private final IVehicleRepository repository;

	public Vehicle execute(Long vehicleId) {
		return this.repository.findById(vehicleId)
			.orElseThrow(() -> new ResourceNotFoundException(VEHICLE, "id", vehicleId));
	}
}
