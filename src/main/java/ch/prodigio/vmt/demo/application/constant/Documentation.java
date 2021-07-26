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
	public static final String import_vehicles_pm_description= "CSV Dataset to import.";
	public static final String import_vehicles_rp_ok_description= "Vehicle has been created";
	public static final String import_vehicles_rp_ex_description= "Import exception";
	public static final String import_vehicles_head_ok_description= "Vehicles has been successfully stored";

	public static final String get_vehicles_op_summary = "Get vehicles";
	public static final String get_vehicles_op_description = "Get previously stored vehicles.";
	public static final String get_vehicles_op_resp_description = "Returns the vehicles stored in database";

	public static final String get_vehicle_by_id_op_summary = "Get vehicle by identifier";
	public static final String get_vehicle_by_id_op_description = "Get vehicle by identifier.";
	public static final String get_vehicle_by_id_op_resp_description = "Return the vehicle stored by identifier.";
	public static final String get_vehicles_rp_ok_description= "Vehicles found";


	/********************************************************************
	 * VehicleRequest's Constants and VehicleResponse's Constants
	 ********************************************************************/
	public static final String vehicleRq_schema_description = "Resource with vehicle input data";
	public static final String vehicleRp_schema_description = "Resource with vehicle response data";

}
