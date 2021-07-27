package ch.prodigio.vmt.demo.application.controller.vehicle.imports.response;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class VehicleViewMapperTest {

	@InjectMocks
	private VehicleViewMapper mapper;

	@Test
	public void when_mapper_is_used_then_response_is_mapped() {
		VehicleView actual = this.mapper.map(
			new Vehicle()
				.setId(1L)
				.setCountyFips(1001)
				.setCountyName("Autauga")
				.setStateName("Alabama")
				.setDate(LocalDate.parse("2020-05-08"))
				.setCountyVmt(3550000.0)
				.setBaselineVmt(3571446.0)
				.setPercentChange(-0.6)
				.setMeanCountyVmt(2790000.0)
				.setMeanPercentChange(-21.88)
				.setDateAtLow(LocalDate.parse("2020-04-12"))
				.setMeanCountyVmtAtLow(1542857.14)
				.setPercentChangeFromLow(80.83));


		assertEquals((new VehicleView()
			.setId(1L)
			.setCountyFips(1001)
			.setCountyName("Autauga")
			.setStateName("Alabama")
			.setDate("2020-05-08")
		), actual);
	}
}