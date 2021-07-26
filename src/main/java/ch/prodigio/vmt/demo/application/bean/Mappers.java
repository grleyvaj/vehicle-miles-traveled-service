package ch.prodigio.vmt.demo.application.bean;

import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.application.controller._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.controller.vehicle.list.response.VehicleResponseMapper;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {

	@Bean
	public Mapper<Vehicle, VehicleResponse> vehicleResponseMapper() {
		return new VehicleResponseMapper();
	}
}
