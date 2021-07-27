package ch.prodigio.vmt.demo.domain.use_case.vehicle.imports;

import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.entity.VehicleBuilder;
import ch.prodigio.vmt.demo.domain.repository.IVehicleRepository;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.imports.VehicleImportsUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class VehicleImportUseCaseTest {

	@InjectMocks
	private VehicleImportsUseCase useCase;

	@Mock
	private IVehicleRepository repository;

	@Test
	public void when_use_case_is_executed_then_repository_is_used() {
		doReturn(new VehicleBuilder().build(0))
			.when(this.repository).create(new VehicleBuilder().build(0));
		doReturn(new VehicleBuilder().build(1))
			.when(this.repository).create(new VehicleBuilder().build(1));
		doReturn(new VehicleBuilder().build(2))
			.when(this.repository).create(new VehicleBuilder().build(2));
		doReturn(new VehicleBuilder().buildList(3))
			.when(this.repository).findAll();

		this.useCase.execute(new VehicleBuilder().buildList(3));

		verify(this.repository).create(new VehicleBuilder().build(0));
		verify(this.repository).create(new VehicleBuilder().build(1));
		verify(this.repository).create(new VehicleBuilder().build(2));
		verify(this.repository).findAll();
	}

	@Test
	public void when_use_case_is_executed_then_vehicles_are_returned() {
		doReturn(new VehicleBuilder().build(0))
			.when(this.repository).create(new VehicleBuilder().build(0));
		doReturn(new VehicleBuilder().build(1))
			.when(this.repository).create(new VehicleBuilder().build(1));
		doReturn(new VehicleBuilder().build(2))
			.when(this.repository).create(new VehicleBuilder().build(2));
		doReturn(new VehicleBuilder().buildList(3))
			.when(this.repository).findAll();

		Iterable<Vehicle> actual = this.useCase.execute(new VehicleBuilder().buildList(3));
		Iterable<Vehicle> expected = Arrays.asList(
			new VehicleBuilder().build(0),
			new VehicleBuilder().build(1),
			new VehicleBuilder().build(2)
		);

		assertEquals(expected, actual);
	}
}
