package ch.prodigio.vmt.demo.application.controller.vehicle;

import ch.prodigio.vmt.demo.application.constant.URIConstant;
import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.application.controller.vehicle._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.controller.vehicle.create.request.VehicleRequest;
import ch.prodigio.vmt.demo.application.controller.vehicle.imports.response.VehicleView;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.create.VehicleCreateUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.get.VehicleFindUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.imports.VehicleImportsUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.list.VehicleListUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.update.VehicleInput;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.update.VehicleUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gloria R. Leyva Jerez
 */
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(path = VehicleMilesTraveledApiController.BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleMilesTraveledApiController implements VehicleMilesTraveledOpenApi {

	protected static final String BASE_PATH = URIConstant.BASE_PATH + URIConstant.API_VERSION;
	protected static final String URI_API = URIConstant.URI_VEHICLE;
	private static final String URI_ENTITY = URIConstant.ENTITY_VEHICLE;

	private final VehicleImportsUseCase vehicleImportsUseCase;
	private final VehicleListUseCase vehicleListUseCase;
	private final VehicleFindUseCase vehicleFindUseCase;
	private final VehicleCreateUseCase vehicleCreateUseCase;
	private final VehicleUpdateUseCase vehicleUpdateUseCase;
	private final Mapper<byte[], List<Vehicle>> vehicleImportMapper;
	private final Mapper<Vehicle, VehicleView> vehicleViewMapper;
	private final Mapper<Vehicle, VehicleResponse> vehicleResponseMapper;
	private final Mapper<VehicleRequest, Vehicle> vehicleRequestMapper;
	private final Mapper<VehicleRequest, VehicleInput> vehicleInputMapper;
	private final RepresentationModelAssembler<VehicleResponse, RepresentationModel<VehicleResponse>> vehicleResponseAssembler;
	private final PagedResourcesAssembler pagedResourcesAssembler;
	private final SuccessfulContentHandler contentHandler;

	@Override
	@PostMapping(path = URI_API + "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> importVehicles(@RequestParam("file") MultipartFile files) throws IOException {
		Iterable<Vehicle> execute = vehicleImportsUseCase.execute(this.vehicleImportMapper.map(files.getBytes()));
		List<VehicleView> vehicleImported = new ArrayList<>();
		execute.forEach(vehicle -> vehicleImported.add(this.vehicleViewMapper.map(vehicle)));
		return ResponseEntity.ok(vehicleImported);
	}

	@Override
	@GetMapping(path = URI_API)
	public ResponseEntity<?> listVehicles(Pageable pageable) {
		Page<VehicleResponse> vehicles = this.vehicleListUseCase.execute(pageable).map(this.vehicleResponseMapper::map);
		PagedModel<VehicleResponse> collModel = this.pagedResourcesAssembler.toModel(
			vehicles,
			this.vehicleResponseAssembler
		);
		return ResponseEntity.ok(collModel);
	}

	@Override
	@GetMapping(path = URI_API + "/{vehicleId}")
	public ResponseEntity<?> getVehicleById(@PathVariable long vehicleId) {
		VehicleResponse vehicleFound = this.vehicleResponseMapper.map(this.vehicleFindUseCase.execute(vehicleId));
		return ResponseEntity.ok(vehicleResponseAssembler.toModel(vehicleFound));
	}

	@Override
	@PostMapping(path = URI_API, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createVehicle(@RequestBody @Valid VehicleRequest vehicleRequest) {
		Vehicle vehicleNew = this.vehicleRequestMapper.map(vehicleRequest);
		VehicleResponse vehicleCreated = this.vehicleResponseMapper.map(this.vehicleCreateUseCase.execute(vehicleNew));
		vehicleResponseAssembler.toModel(vehicleCreated);

		String msg = contentHandler.successCreateAlert(URI_ENTITY + " " + vehicleCreated.getCountyName());

		return ResponseEntity
			.created(vehicleCreated.getRequiredLink(IanaLinkRelations.SELF).toUri())
			.headers(SuccessfulContentHandler.createHeaders(msg))
			.body(vehicleCreated);
	}

	@PutMapping(path = URI_API + "/{vehicle}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateVehicle(
		@PathVariable("vehicle") Vehicle vehicle,
		@RequestBody @Valid VehicleRequest vehicleRequest
	) {
		VehicleResponse vehicleUpdated = this.vehicleResponseMapper.map(this.vehicleUpdateUseCase.execute(
			vehicleInputMapper.map(vehicleRequest),
			vehicle
		));
		vehicleResponseAssembler.toModel(vehicleUpdated);

		String msg = contentHandler.successUpdateAlert(URI_ENTITY + " " + vehicleUpdated.getCountyName());

		return ResponseEntity
			.created(vehicleUpdated.getRequiredLink(IanaLinkRelations.SELF).toUri())
			.headers(SuccessfulContentHandler.createHeaders(msg))
			.body(vehicleUpdated);
	}
}
