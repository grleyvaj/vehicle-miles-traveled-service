package ch.prodigio.vmt.demo.domain.repository;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IVehicleRepository {

	Vehicle create(Vehicle vehicle);

	Page<Vehicle> find(Pageable pageable);

	Optional<Vehicle> findById(long vehicleId);
}
