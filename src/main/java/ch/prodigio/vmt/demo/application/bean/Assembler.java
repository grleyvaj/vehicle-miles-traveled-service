package ch.prodigio.vmt.demo.application.bean;

import ch.prodigio.vmt.demo.application.controller.vehicle._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.controller.vehicle.list.response.VehicleAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

@Configuration
public class Assembler {

	@Bean
	public RepresentationModelAssembler<VehicleResponse, RepresentationModel<VehicleResponse>> vehicleResponseAssembler() {
		return new VehicleAssembler();
	}
}
