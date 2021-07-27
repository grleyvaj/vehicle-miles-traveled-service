package ch.prodigio.vmt.demo.application.controller.vehicle.imports.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class VehicleViewTest {

	@Test
	public void when_response_view_is_created_then_data_can_be_retrieved() {
		VehicleView actual = new VehicleView()
			.setId(1L)
			.setCountyFips(1001)
			.setCountyName("Autauga")
			.setStateName("Alabama")
			.setDate("2020-05-08");

		assertEquals(1L, actual.getId());
		assertEquals(1001, actual.getCountyFips());
		assertEquals("Autauga", actual.getCountyName());
		assertEquals("Alabama", actual.getStateName());
		assertEquals("2020-05-08", actual.getDate());
	}
}