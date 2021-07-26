package ch.prodigio.vmt.demo.application.controller.vehicle;

import ch.prodigio.vmt.demo.application.constant.URIConstant;
import ch.prodigio.vmt.demo.application.contract.Mapper;
import ch.prodigio.vmt.demo.application.controller._response.VehicleResponse;
import ch.prodigio.vmt.demo.domain.entity.Vehicle;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.VehicleFindUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.VehicleImportsUseCase;
import ch.prodigio.vmt.demo.domain.use_case.vehicle.VehicleListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Gloria R. Leyva Jerez
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = VehicleMilesTraveledApiController.BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleMilesTraveledApiController implements VehicleMilesTraveledOpenApi {

	protected static final String BASE_PATH = URIConstant.BASE_PATH + URIConstant.API_VERSION;
	protected static final String URI_API = URIConstant.URI_VEHICLE;

	private final VehicleImportsUseCase vehicleImportsUseCase;
	private final VehicleListUseCase vehicleListUseCase;
	private final VehicleFindUseCase vehicleFindUseCase;
	private final Mapper<Vehicle, VehicleResponse> vehicleResponseMapper;
	private final Mapper<byte[], List<Vehicle>> vehicleImportMapper;
	private final RepresentationModelAssembler<VehicleResponse, RepresentationModel<VehicleResponse>> vehicleResponseAssembler;
	private final PagedResourcesAssembler pagedResourcesAssembler;

	@Override
	@PostMapping(path = URI_API + "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> importVehicles(@RequestParam("file") MultipartFile files) throws IOException {
		vehicleImportsUseCase.execute(vehicleImportMapper.map(files.getBytes()));
		return ResponseEntity.ok(null);
	}

	@Override
	@GetMapping(path = URI_API)
	public ResponseEntity<?> listVehicles(Pageable pageable) {
		Page<VehicleResponse> vehicles = this.vehicleListUseCase.execute(pageable).map(vehicleResponseMapper::map);
		PagedModel<VehicleResponse> collModel = pagedResourcesAssembler.toModel(vehicles, vehicleResponseAssembler);
		return ResponseEntity.ok(collModel);
	}

	@Override
	@GetMapping(path = URI_API + "/{vehicleId}")
	public ResponseEntity<?> getVehicleById(@PathVariable Long vehicleId) {
		VehicleResponse vehicleFound = vehicleResponseMapper.map(this.vehicleFindUseCase.execute(vehicleId));
		return ResponseEntity.ok(vehicleResponseAssembler.toModel(vehicleFound));
	}
}
