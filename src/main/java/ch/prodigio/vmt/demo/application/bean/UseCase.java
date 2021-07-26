package ch.prodigio.vmt.demo.application.bean;

import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.VehicleFindUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.VehicleImportsUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.VehicleListUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCase {

	@Bean
	public VehicleImportsUseCase vehicleImportsUseCase(IVehicleRepository vehicleRepository) {
		return new VehicleImportsUseCase(vehicleRepository);
	}

	@Bean
	public VehicleListUseCase vehicleListUseCase(IVehicleRepository vehicleRepository) {
		return new VehicleListUseCase(vehicleRepository);
	}

	@Bean
	public VehicleFindUseCase vehicleFindUseCase(IVehicleRepository vehicleRepository) {
		return new VehicleFindUseCase(vehicleRepository);
	}
}
