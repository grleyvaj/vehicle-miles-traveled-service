package ch.prodigio.vmt.demo.application.controller.vehicle;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Vehicle Miles Traveled API Controller Tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleMilesTraveledApiControllerIT {

	private final static String uri_vehicles = "http://http://localhost:8081/vmt/v1/vehicles";
	private final static String pageable = "?page=0&size=5&sort=id,asc";
	private final static String uri_get_vehicles_by_id = "http://http://localhost:8081/vmt/v1/vehicles/";

	@Autowired
	protected MockMvc mockMvc;

	@Test
	@DisplayName("Test get vehicles stored in database.")
	public void given_a_vehicle_when_invoke_get_return_vehicles() throws Exception {
		// GIVEN
		// createTestVehicle();

		// WHEN
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
			//.get(String.format(uri_vehicles + "%s", pageable))
			.get("http://localhost:8081/vmt/v1/vehicles?page=0&size=5&sort=id,asc")
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andReturn();

		// THEN
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		// String content = mvcResult.getResponse().getContentAsString();
	}

	private Vehicle createTestVehicle() {
		return new Vehicle()
			.setId(2L)
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
			.setPercentChangeFromLow(80.83);
	}
}
