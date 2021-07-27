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

	private final IVehicleJpaRepository jpaRepository;

	@Override
	public Vehicle create(Vehicle vehicle) {
		return jpaRepository.save(vehicle);
	}

	@Override
	public Page<Vehicle> find(Pageable pageable) {
		return jpaRepository.findAll(pageable);
	}

	@Override
	public Optional<Vehicle> findById(long vehicleId) {
		return jpaRepository.findById(vehicleId);
	}

	public Iterable<Vehicle> findAll() {
		return jpaRepository.findAll();
	}

	@Override
	public void deleteAll() {
		jpaRepository.deleteAll();
	}

	@Override
	public Vehicle update(Vehicle vehicle) {
		return jpaRepository.save(vehicle);
	}

	@Override
	public void deleteById(long vehicleId) {
		jpaRepository.deleteById(vehicleId);
	}
}
