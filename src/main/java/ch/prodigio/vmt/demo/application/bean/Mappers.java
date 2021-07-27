package ch.prodigio.vmt.demo.application.bean;

import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.application.controller.vehicle._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.controller.vehicle.create.request.VehicleInputMapper;
import ch.prodigio.vmt.demo.application.controller.vehicle.create.request.VehicleRequest;
import ch.prodigio.vmt.demo.application.controller.vehicle.create.request.VehicleRequestMapper;
import ch.prodigio.vmt.demo.application.controller.vehicle.imports.response.VehicleImportMapper;
import ch.prodigio.vmt.demo.application.controller.vehicle.imports.response.VehicleView;
import ch.prodigio.vmt.demo.application.controller.vehicle.imports.response.VehicleViewMapper;
import ch.prodigio.vmt.demo.application.controller.vehicle.list.response.VehicleResponseMapper;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.update.VehicleInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Mappers {

	@Bean
	public Mapper<Vehicle, VehicleResponse> vehicleResponseMapper() {
		return new VehicleResponseMapper();
	}

	@Bean
	public Mapper<byte[], List<Vehicle>> vehicleImportMapper() {
		return new VehicleImportMapper();
	}

	@Bean
	public Mapper<Vehicle, VehicleView> vehicleViewMapper() {
		return new VehicleViewMapper();
	}

	@Bean
	public Mapper<VehicleRequest, Vehicle> vehicleRequestMapper() {
		return new VehicleRequestMapper();
	}

	@Bean
	public Mapper<VehicleRequest, VehicleInput> vehicleInputMapper() {
		return new VehicleInputMapper();
	}
}
