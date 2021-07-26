package ch.prodigio.vmt.demo.application.controller.vehicle.list.response;

import ch.prodigio.vmt.demo.application.controller._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.controller.vehicle.list.response.VehicleAssembler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.RepresentationModel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class VehicleAssemblerTest {

	@InjectMocks
	private VehicleAssembler assembler;

	@Test
	public void when_assembler_is_used_then_links_is_add() {
		RepresentationModel<VehicleResponse> actual = this.assembler.toModel(
			new VehicleResponse()
				.setId(1L)
				.setCountyFips(1001)
				.setCountyName("Autauga")
				.setStateName("Alabama")
				.setDate("2020-05-08")
				.setCountyVmt(3550000.0)
				.setBaselineVmt(3571446.0)
				.setPercentChange(-0.6)
				.setMeanCountyVmt(2790000.0)
				.setMeanPercentChange(-21.88)
				.setDateAtLow("2020-04-12")
				.setMeanCountyVmtAtLow(1542857.14)
				.setPercentChangeFromLow(80.83));

		assertNotNull(actual.getLinks());
	}

}