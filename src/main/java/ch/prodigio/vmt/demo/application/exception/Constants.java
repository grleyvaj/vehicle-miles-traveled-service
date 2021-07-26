package ch.prodigio.vmt.demo.application.exception;


/**
 * @author Gloria R. Leyva Jerez
 * This class contains the OpenAPI documentation of the APIs of the Exception (ErrorInfo)
 */
public class Constants {

    /***********************
     * ErrorInfo's constants
     **********************/
    public static final String error_schema_description = "Entity that manages the error information that occurs when an exception is thrown.";

    public static final String uri_description = "URI where the exception is throud";
    public static final String uri_example = "/vmt/v1/vehicles";

    public static final String method_description = "Method that produces the exception";
    public static final String method_example = "GET | POST | PUT | DELETE | ...";

    public static final String message_description = "Error description";
    public static final String message_example = "Se ha producido un error debido a que ...";

    public static final String httpStatus_description = "HttpStatus of response";
    public static final String httpStatus_example = "Bad Request | Not Found | Method Not Allowed | ConstraintViolationshared.exception | Precondition Failed | Unprocessable Entity | ...";

    public static final String statusCode_description = "Automatic response status code";
    public static final String statusCode_example = "400 | 404 | 405 | 409 | 412 | 422 | ...";

    public static final String errorCode_description = "Error code generated in the system";
    public static final String errorCode_example = "5| 4 | 6 | 3 | 1 | 2 | ...";

    public static final String type_description = "Exception thrown";
    public static final String type_example = "HttpMessageNotReadableshared.exception | ResourceNotFoundException | HttpRequestMethodNotSupportedshared.exception | ConstraintViolationshared.exception | NotValidIDshared.exception | Unprocessable Entity | ...";


    /***********************
     * ExceptionResponseHandler's constants
     **********************/

    public static final String notFound_resp_description = "The requested resource does not exist.";
    public static final String notFound_resp_name = "Returns an ErrorInfo when a ResourceNotFoundException occurs because the requested resource does not exist.";

    public static final String internalError_resp_description = "Internal server error.";
    public static final String internalError_resp_name = "Returns an ErrorInfo when an HttpServerErrorException occurs due to an internal error in the server.";

    public static final String incompletePtmError_resp_description = "Absence of parameters that are required to complete the request made. For example: token, path variables or request parameters.";
    public static final String incompletePtmError_resp_name = "Returns an ErrorInfo when a MissingRequestHeaderException occurs due to missing parameters that are required to complete the request made.";

    public static final String csvExceptionError_resp_description = "Error opening or reading the import file.";
    public static final String csvExceptionError_resp_name = "Returns an ErrorInfo when CsvErrorException occurs due to: Reading CSV Error or Closing fileReader/csvParser Error!.";
}
