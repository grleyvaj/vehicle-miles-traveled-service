package ch.prodigio.vmt.demo.domain.use_case.vehicle.delete;

import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VehicleRemoveUseCase {

	private final IVehicleRepository repository;

	public void execute(long id) {
		if(repository.findById(id).isPresent())
			repository.deleteById(id);
	}
}
