package ch.prodigio.vmt.demo.application.controller.vehicle.list.response;

import ch.prodigio.vmt.demo.application.controller.vehicle._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.controller.vehicle.VehicleMilesTraveledApiController;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Gloria R. Leyva Jerez
 */
public class VehicleAssembler implements RepresentationModelAssembler<VehicleResponse, RepresentationModel<VehicleResponse>> {

	@Override
	public RepresentationModel<VehicleResponse> toModel(VehicleResponse entity) {
		entity.add(linkTo(methodOn(VehicleMilesTraveledApiController.class).getVehicleById(entity.getId())).withSelfRel());
		return entity;
	}
}
