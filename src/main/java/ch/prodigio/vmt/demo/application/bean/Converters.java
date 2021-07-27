package ch.prodigio.vmt.demo.application.bean;

import ch.prodigio.vmt.demo.application.controller.vehicle.update.request.VehicleConverter;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import org.springframework.context.annotation.Bean;

public class Converters {

	@Bean
	public VehicleConverter partnerConverter(IVehicleRepository vehicleRepository) {
		return new VehicleConverter(vehicleRepository);
	}
}
