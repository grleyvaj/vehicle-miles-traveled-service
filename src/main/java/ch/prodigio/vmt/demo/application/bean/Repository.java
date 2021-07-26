package ch.prodigio.vmt.demo.application.bean;

import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import ch.prodigio.vmt.demo.infrastructure.IVehicleJpaRepository;
import ch.prodigio.vmt.demo.infrastructure.VehicleJpaRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repository {

	@Bean
	public IVehicleRepository vehicleRepository(
		IVehicleJpaRepository repository
	) {
		return new VehicleJpaRepositoryImpl(repository);
	}
}
