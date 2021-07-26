package ch.prodigio.vmt.demo.application.controller.vehicle;

import ch.prodigio.vmt.demo.application.constant.Documentation;
import ch.prodigio.vmt.demo.application.controller._response.VehicleResponse;
import ch.prodigio.vmt.demo.application.exception.ErrorInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
		security = {@SecurityRequirement(name = "sso_auth", scopes = {"vmt_manage"})},
		tags = {"vehicles"}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = Documentation.import_vehicles_rp_ok_description, headers = @Header(name = "app-success", description = Documentation.import_vehicles_head_ok_description)),
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
		security = {@SecurityRequirement(name = "sso_auth", scopes = {"vmt_manage"})},
		tags = {"vehicles"}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = Documentation.get_vehicles_rp_ok_description, content = @Content(schema = @Schema(type = "array", implementation = VehicleResponse.class))),
	})
	public ResponseEntity<?> listVehicles(
		@Parameter(in = ParameterIn.QUERY, description = Documentation.pageable_description, example = Documentation.pageable_request, required = false) Pageable pageable
	);

	@Operation(summary = Documentation.get_vehicle_by_id_op_summary,
		description = Documentation.get_vehicle_by_id_op_description,
		tags = {"vehicles"})
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = Documentation.get_vehicle_by_id_op_resp_200_description, content = @Content(schema = @Schema(type = "object", implementation = VehicleResponse.class))),
		@ApiResponse(responseCode = "404", description = Documentation.get_vehicle_by_id_op_resp_404_description, content = @Content(schema = @Schema(type = "object", implementation = VehicleResponse.class))),
	})
	public ResponseEntity<?> getVehicleById(
		@Parameter(description = Documentation.id_description, example = "1", required = true) Long vehicleId
	);
}
