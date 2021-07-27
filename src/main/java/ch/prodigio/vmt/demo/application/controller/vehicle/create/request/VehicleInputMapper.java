package ch.prodigio.vmt.demo.application.controller.vehicle.create.request;

import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.update.VehicleInput;

public class VehicleInputMapper implements Mapper<VehicleRequest, VehicleInput> {

	@Override
	public VehicleInput map(VehicleRequest request) {
		return new VehicleInput()
			.setId(request.getId())
			.setCountyFips(request.getCountyFips())
			.setCountyName(request.getCountyName())
			.setStateName(request.getStateName())
			.setDate(String.valueOf(request.getDate()))
			.setCountyVmt(request.getCountyVmt())
			.setBaselineVmt(request.getBaselineVmt())
			.setPercentChange(request.getPercentChange())
			.setMeanCountyVmt(request.getMeanCountyVmt())
			.setMeanPercentChange(request.getMeanPercentChange())
			.setDateAtLow(String.valueOf(request.getDateAtLow()))
			.setMeanCountyVmtAtLow(request.getMeanCountyVmtAtLow())
			.setPercentChangeFromLow(request.getPercentChangeFromLow()
			);
	}
}
