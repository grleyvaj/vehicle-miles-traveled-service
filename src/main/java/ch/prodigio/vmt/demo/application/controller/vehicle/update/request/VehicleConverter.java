package ch.prodigio.vmt.demo.application.controller.vehicle.update.request;

import ch.prodigio.vmt.demo.application.exception.EndpointArgumentException;
import ch.prodigio.vmt.demo.application.exception.ResourceNotFoundException;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

@RequiredArgsConstructor
public class VehicleConverter implements Converter<String, Vehicle> {

	private final IVehicleRepository repository;

	@Override
	public Vehicle convert(String id) {
		Optional<Vehicle> vehicle = this.repository.findById(this.convertId(id));
		if(vehicle.isPresent()) {
			return vehicle.get();
		}
		else
			throw new ResourceNotFoundException("Vehicle", "id", id);
	}

	private Long convertId(String id) {
		try {
			return Long.parseLong(id);
		} catch(NumberFormatException e) {
			throw new EndpointArgumentException(String.format("Cannot convert %s to long", id), e);
		}
	}
}
