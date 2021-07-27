package ch.prodigio.vmt.demo.domain.use_case.vehicle.update;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class VehicleUpdateUseCase {

	private final IVehicleRepository repository;

	public Vehicle execute(VehicleInput input, Vehicle vehicle) {
		vehicle.setCountyFips(input.getCountyFips());
		vehicle.setCountyName(input.getCountyName());
		vehicle.setStateName(input.getStateName());
		vehicle.setDate(LocalDate.parse(input.getDate()));
		vehicle.setCountyVmt(input.getCountyVmt());
		vehicle.setBaselineVmt(input.getBaselineVmt());
		vehicle.setPercentChange(input.getPercentChange());
		vehicle.setMeanCountyVmt(input.getMeanCountyVmt());
		vehicle.setMeanPercentChange(input.getMeanPercentChange());
		vehicle.setDateAtLow(LocalDate.parse(input.getDateAtLow()));
		vehicle.setMeanCountyVmtAtLow(input.getMeanCountyVmtAtLow());
		vehicle.setPercentChangeFromLow(input.getPercentChangeFromLow());
		return this.repository.update(vehicle);
	}
}
