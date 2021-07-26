package ch.prodigio.vmt.demo.application.controller._response;

import ch.prodigio.vmt.demo.application.controller._response.VehicleResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class VehicleResponseTest {

	@Test
	public void when_response_is_created_then_data_can_be_retrieved() {
		VehicleResponse actual = new VehicleResponse()
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
			.setPercentChangeFromLow(80.83);

		assertEquals(1L, actual.getId());
		assertEquals(1001, actual.getCountyFips());
		assertEquals("Autauga", actual.getCountyName());
		assertEquals("Alabama", actual.getStateName());
		assertEquals("2020-05-08", actual.getDate());
		assertEquals(3550000.0, actual.getCountyVmt());
		assertEquals(3571446.0, actual.getBaselineVmt());
		assertEquals(-0.6, actual.getPercentChange());
		assertEquals(2790000.0, actual.getMeanCountyVmt());
		assertEquals(-21.88, actual.getMeanPercentChange());
		assertEquals("2020-04-12", actual.getDateAtLow());
		assertEquals(1542857.14, actual.getMeanCountyVmtAtLow());
		assertEquals(80.83, actual.getPercentChangeFromLow());
	}

}