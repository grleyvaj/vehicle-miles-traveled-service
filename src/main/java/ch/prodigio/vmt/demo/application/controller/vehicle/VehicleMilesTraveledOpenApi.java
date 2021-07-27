package ch.prodigio.vmt.demo.application.controller.vehicle;

import ch.prodigio.vmt.demo.application.constant.Documentation;
import ch.prodigio.vmt.demo.application.controller.vehicle._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.controller.vehicle.create.request.VehicleRequest;
import ch.prodigio.vmt.demo.application.exception.ErrorInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Gloria R. Leyva Jerez
 */
@Tag(name = Documentation.vmt_tag_name, description = Documentation.vmt_tag_description)
public interface VehicleMilesTraveledOpenApi {

	@Operation(
		summary = Documentation.import_vehicles_op_summary,
		description = Documentation.import_vehicles_op_description,
		operationId = "importVehicles",
		tags = {"vehicles"}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = Documentation.import_vehicles_rp_ok_description),
		@ApiResponse(responseCode = "400", description = Documentation.import_vehicles_rp_ex_description, content = @Content(schema = @Schema(implementation = ErrorInfo.class))),
	})
	public ResponseEntity<?> importVehicles(
		@Parameter(in = ParameterIn.DEFAULT, description = Documentation.import_vehicles_pm_description, schema = @Schema(type = "file", required = true))
		@RequestParam("file") MultipartFile files
	) throws IOException;

	@Operation(
		summary = Documentation.get_vehicles_op_summary,
		description = Documentation.get_vehicles_op_description,
		operationId = "listVehicles",
		tags = {"vehicles"}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = Documentation.get_vehicles_rp_ok_description, content = @Content(schema = @Schema(type = "array", implementation = VehicleResponse.class))),
	})
	public ResponseEntity<?> listVehicles(
		@Parameter(in = ParameterIn.QUERY, description = Documentation.pageable_description, example = Documentation.pageable_request, required = false) Pageable pageable
	);

	@Operation(
		summary = Documentation.get_vehicle_by_id_op_summary,
		description = Documentation.get_vehicle_by_id_op_description,
		tags = {"vehicles"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = Documentation.get_vehicle_by_id_op_resp_200_description, content = @Content(schema = @Schema(type = "object", implementation = VehicleResponse.class))),
		@ApiResponse(responseCode = "404", description = Documentation.get_vehicle_by_id_op_resp_404_description, content = @Content(schema = @Schema(type = "object", implementation = VehicleResponse.class))),
	})
	public ResponseEntity<?> getVehicleById(
		@Parameter(description = Documentation.id_description, example = "1", required = true) @PathVariable long vehicleId
	);

	@Operation(
		summary = Documentation.createVehicle_op_summary,
		description = Documentation.createVehicle_op_description,
		tags = {"vehicles"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = Documentation.createVehicle_resp_description, headers = @Header(name = "app-success", description = Documentation.createVehicle_head_description), content = @Content(schema = @Schema(type = "object", implementation = VehicleResponse.class)))
	})
	public ResponseEntity<?> createVehicle(
		@Parameter(description = Documentation.createVehicle_ptm_description, required = true)
		@RequestBody VehicleRequest vehicleRequest
	);

	@Operation(
		summary = Documentation.updateVehicle_op_summary,
		description = Documentation.updateVehicle_op_description,
		tags = {"vehicles"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = Documentation.updateVehicle_resp_description, headers = @Header(name = "app-success", description = Documentation.updateVehicle_head_description), content = @Content(schema = @Schema(type = "object", implementation = VehicleResponse.class))),
		@ApiResponse(responseCode = "404", description = Documentation.get_vehicle_by_id_op_resp_404_description, content = @Content(schema = @Schema(type = "object", implementation = VehicleResponse.class))),
	})
	public ResponseEntity<?> updateVehicle(
		@Parameter(description = Documentation.updateVehicle_pt1_description, required = true, example = "1")
		@PathVariable() long vehicleId,
		@Parameter(description = Documentation.updateVehicle_pt2_description, required = true)
		@RequestBody VehicleRequest vehicleRequest
	);

	@Operation(
		summary = Documentation.deleteCauseCreateById_op_summary,
		description = Documentation.deleteCauseCreateById_op_description,
		tags = {"vehicles"})
	@ApiResponse(responseCode = "204", description = Documentation.deleteCauseCreateById_resp_description, headers = @Header(name = "app-success", description = Documentation.deleteCauseCreateById_head_description))
	public ResponseEntity<?> deleteVehicleById(
		@Parameter(description = Documentation.deleteCauseCreateById_ptm_description, required = true, example = "1")
		@PathVariable long vehicleId
	);
}