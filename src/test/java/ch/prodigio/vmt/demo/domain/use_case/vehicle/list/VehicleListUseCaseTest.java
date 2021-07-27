package ch.prodigio.vmt.demo.domain.use_case.vehicle.list;

import ch.prodigio.vmt.demo.application.builder.PageBuilder;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.entity.VehicleBuilder;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.list.VehicleListUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class VehicleListUseCaseTest {

	@InjectMocks
	private VehicleListUseCase useCase;

	@Mock
	private IVehicleRepository repository;

	@Test
	public void when_use_case_is_executed_then_repository_is_used() {
		doReturn(new PageImpl(new VehicleBuilder().buildList(2), new PageBuilder().build(2, 20, "id.asc"), 2))
			.when(this.repository).find(new PageBuilder().build(2, 20, "id.asc"));

		this.useCase.execute(new PageBuilder().build(2, 20, "id.asc"));

		verify(this.repository).find(new PageBuilder().build(2, 20, "id.asc"));
	}

	@Test
	public void when_use_case_is_executed_then_vehicles_are_returned() {
		doReturn(new PageImpl(new VehicleBuilder().buildList(2), new PageBuilder().build(2, 20, "id.asc"), 2))
			.when(this.repository).find(new PageBuilder().build(2, 20, "id.asc"));

		Page<Vehicle> actual = this.useCase.execute(new PageBuilder().build(2, 20, "id.asc"));

		assertEquals(
			new PageImpl(
				new VehicleBuilder().buildList(2),
				new PageBuilder().build(2, 20, "id.asc"),
				2
			),
			actual
		);
	}
}
