package ch.prodigio.vmt.demo.application.constant;

/**
 * @author Gloria R. Leyva Jerez
 * This class contains the OpenAPI documentation of the APIs
 */
public class Documentation {

	/***********************
	 * General constants
	 **********************/
	public static final String pageable_request = "{"
		+ "\"page\": 0,"
		+ "\"size\": 5,"
		+ "\"sort\": \"id,asc\""
		+ "}";

	private static final String pageable_response =
		"\"page\": " + "{"
			+ "\"size\": 5,"
			+ "\"totalElements\": 15,"
			+ "\"totalPages\": 3,"
			+ "\"number\": 0"
			+ "}";

	public static final String pageable_description = "Parameter to indicate pagination";
	public static final String id_description = "Vehicle identifier";

	/***********************
	 * VehicleMilesTraveledApiControllerApiController's Constants
	 **********************/
	public static final String vmt_tag_name = "Vehicle Miles Traveled Service";
	public static final String vmt_tag_description = "CRUD of operations for manage Vehicle Miles Traveled";

	public static final String import_vehicles_op_summary = "Import vehicles";
	public static final String import_vehicles_op_description = "Import vehicles from dataset.";
	public static final String import_vehicles_pm_description = "CSV Dataset to import.";
	public static final String import_vehicles_rp_ok_description = "Vehicle has been imported";
	public static final String import_vehicles_rp_ex_description = "Import exception";
	public static final String import_vehicles_head_ok_description = "Vehicles has been successfully stored";

	public static final String get_vehicles_op_summary = "Get vehicles";
	public static final String get_vehicles_op_description = "Get previously stored vehicles.";
	public static final String get_vehicles_op_resp_description = "Returns the vehicles stored in database";

	public static final String get_vehicle_by_id_op_summary = "Get vehicle by identifier";
	public static final String get_vehicle_by_id_op_description = "Get vehicle by identifier.";
	public static final String get_vehicle_by_id_op_resp_200_description = "Return the vehicle stored by identifier.";
	public static final String get_vehicle_by_id_op_resp_404_description = "Resource Not Found.";
	public static final String get_vehicles_rp_ok_description = "Vehicles found";

	public static final String createVehicle_op_summary = "Add a vehicle";
	public static final String createVehicle_op_description = "Add a vehicle with the information provided in VehicleRequest.";
	public static final String createVehicle_head_description = "Vehicle successfully registered";
	public static final String createVehicle_resp_description = "Returns a VehicleResponse resource with the vehicle information created and its corresponding links successfully.";
	public static final String createVehicle_ptm_description = "Parameter that indicates the VehicleRequest with the information of the vehicle to be added.";

	public static final String updateVehicle_op_summary = "Update vehicle";
	public static final String updateVehicle_op_description = "Update the vehicle corresponding to the specified identifier with the information provided in VehicleRequest.";
	public static final String updateVehicle_head_description = "Vehicle successfully updated";
	public static final String updateVehicle_resp_description = "Returns a VehicleResponse resource with updated information and corresponding links in a satisfactory manner.";
	public static final String updateVehicle_pt1_description = "Parameter indicating the identifier of the vehicle to be updated.";
	public static final String updateVehicle_pt2_description = "Parameter indicating the VehicleRequest with the information of the vehicle to be updated.";

	public static final String deleteCauseCreateById_op_summary = "Remove vehicle";
	public static final String deleteCauseCreateById_op_description = "Remove the vehicle corresponding to the specified identifier.";
	public static final String deleteCauseCreateById_head_description = "Vehicle successfully removed";
	public static final String deleteCauseCreateById_resp_description = "Successfully removes vehicle and does not return contents.";
	public static final String deleteCauseCreateById_ptm_description = "Parameter indicating the vehicle identifier of the vehicle to be removed.";

	/********************************************************************
	 * VehicleRequest's Constants and VehicleResponse's Constants
	 ********************************************************************/
	public static final String vehicleRq_schema_description = "Resource with vehicle input data";
	public static final String vehicleRp_schema_description = "Resource with vehicle response data";
	public static final String vehicleRpView_schema_description = "Resource with vehicle response data";

}
