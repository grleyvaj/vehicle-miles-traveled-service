package ch.prodigio.vmt.demo.domain.use_case.vehicle;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class VehicleListUseCase {

	private final IVehicleRepository repository;

	public Page<Vehicle> execute(Pageable pageable) {
		return this.repository.find(pageable);
	}
}
