package ch.prodigio.vmt.demo.infrastructure;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author Gloria R. Leyva Jerez
 */
@RequiredArgsConstructor
public class VehicleJpaRepositoryImpl implements IVehicleRepository {

	private final IVehicleJpaRepository repository;

	@Override
	public Vehicle create(Vehicle vehicle) {
		return repository.save(vehicle);
	}

	@Override
	public Page<Vehicle> find(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Optional<Vehicle> findById(long vehicleId) {
		return repository.findById(vehicleId);
	}
}
