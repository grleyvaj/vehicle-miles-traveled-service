package ch.prodigio.vmt.demo.application.bean;

import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.create.VehicleCreateUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.delete.VehicleRemoveUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.get.VehicleFindUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.imports.VehicleImportsUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.list.VehicleListUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.update.VehicleUpdateUseCase;
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

	@Bean
	public VehicleCreateUseCase vehicleCreateUseCase(IVehicleRepository vehicleRepository) {
		return new VehicleCreateUseCase(vehicleRepository);
	}

	@Bean
	public VehicleUpdateUseCase vehicleUpdateUseCase(IVehicleRepository vehicleRepository) {
		return new VehicleUpdateUseCase(vehicleRepository);
	}

	@Bean
	public VehicleRemoveUseCase vehicleRemoveUseCase(IVehicleRepository vehicleRepository) {
		return new VehicleRemoveUseCase(vehicleRepository);
	}
}
