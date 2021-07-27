package ch.prodigio.vmt.demo.application.controller.vehicle;

import ch.prodigio.vmt.demo.application.controller.vehicle._response.VehicleResponse;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
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

	private final static String uri_vehicles = "http://localhost:8081/vmt/v1/vehicles";

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	protected IVehicleRepository repository;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	@AfterEach
	public void setUp() {
		repository.deleteAll();
	}

	@Test
	@DisplayName("Test get vehicles stored in database.")
	public void given_a_vehicle_when_invoke_get_return_vehicles() throws Exception {
		// GIVEN
		createTestVehicle();

		// WHEN
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
			.get(uri_vehicles + "?page=0&size=5&sort=id,asc")
			.accept(MediaType.APPLICATION_JSON_VALUE))
			.andReturn();

		// THEN
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	@DisplayName("Get Vehicle with correct data")
	public void when_invoke_get_by_id_then_vehicle_is_returned() throws Exception {
		// GIVEN
		Vehicle vehicle = this.createTestVehicle();

		// WHEN
		MockHttpServletResponse response = mockMvc
			.perform(MockMvcRequestBuilders
				.get(uri_vehicles + "/{vehicleId}", vehicle.getId()))
			.andReturn().getResponse();

		VehicleResponse body = objectMapper.readValue(response.getContentAsString(), VehicleResponse.class);

		// THEN
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(vehicle.getId(), body.getId());
		assertEquals(vehicle.getCountyFips(), body.getCountyFips());
		assertEquals(vehicle.getCountyName(), body.getCountyName());
		assertEquals(vehicle.getStateName(), body.getStateName());
	}

	@Test
	@DisplayName("Try to get non existent Vehicle")
	public void when_invoke_get_by_non_existent_id_then_not_found_is_returned() throws Exception {
		// WHEN
		MockHttpServletResponse response = mockMvc
			.perform(MockMvcRequestBuilders
				.get(uri_vehicles + "/{vehicleId}", 0))
			.andReturn().getResponse();

		// THEN
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}

	private Vehicle createTestVehicle() {
		Vehicle vehicle = new Vehicle()
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

		return repository.create(vehicle);
	}
}
