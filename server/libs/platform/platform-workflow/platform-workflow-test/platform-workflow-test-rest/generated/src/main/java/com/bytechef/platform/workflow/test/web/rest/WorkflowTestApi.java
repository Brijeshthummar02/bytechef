/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.workflow.test.web.rest;

import com.bytechef.platform.workflow.test.web.rest.model.WorkflowTestExecutionModel;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-19T13:43:58.925907+01:00[Europe/Zagreb]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "workflow-test", description = "The Platform Workflow Test Internal API")
public interface WorkflowTestApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /workflows/{id}/tests : Execute a workflow synchronously for testing purpose
     * Execute a workflow synchronously for testing purposes.
     *
     * @param id Id of the workflow to execute. (required)
     * @return The output expected by the workflow. (status code 200)
     */
    @Operation(
        operationId = "testWorkflow",
        summary = "Execute a workflow synchronously for testing purpose",
        description = "Execute a workflow synchronously for testing purposes.",
        tags = { "workflow-test" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The output expected by the workflow.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowTestExecutionModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/workflows/{id}/tests",
        produces = { "application/json" }
    )
    
    default ResponseEntity<WorkflowTestExecutionModel> testWorkflow(
        @Parameter(name = "id", description = "Id of the workflow to execute.", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"triggerExecution\" : { \"retryDelayFactor\" : 9, \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"batch\" : true, \"icon\" : \"icon\", \"error\" : { \"stackTrace\" : [ \"stackTrace\", \"stackTrace\" ], \"message\" : \"message\" }, \"priority\" : 5, \"title\" : \"title\", \"type\" : \"type\", \"executionTime\" : 1, \"output\" : \"{}\", \"retryDelay\" : \"retryDelay\", \"input\" : { \"key\" : \"\" }, \"retryDelayMillis\" : 6, \"maxRetries\" : 4, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"workflowTrigger\" : { \"metadata\" : { \"key\" : \"\" }, \"name\" : \"name\", \"description\" : \"description\", \"label\" : \"label\", \"type\" : \"type\", \"parameters\" : { \"key\" : \"\" }, \"connections\" : [ { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 7, \"key\" : \"key\", \"required\" : true }, { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 7, \"key\" : \"key\", \"required\" : true } ], \"timeout\" : \"timeout\" }, \"id\" : \"id\", \"retryAttempts\" : 9, \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"CREATED\" }, \"job\" : { \"outputs\" : { \"key\" : \"\" }, \"taskExecutions\" : [ { \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"icon\" : \"icon\", \"error\" : { \"stackTrace\" : [ \"stackTrace\", \"stackTrace\" ], \"message\" : \"message\" }, \"title\" : \"title\", \"type\" : \"type\", \"output\" : \"{}\", \"retryDelay\" : \"retryDelay\", \"retryDelayMillis\" : 4, \"id\" : \"id\", \"retryAttempts\" : 9, \"retryDelayFactor\" : 3, \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"workflowTask\" : { \"metadata\" : { \"key\" : \"\" }, \"pre\" : [ null, null ], \"destination\" : { \"componentName\" : \"componentName\", \"componentVersion\" : 1 }, \"description\" : \"description\", \"label\" : \"label\", \"source\" : { \"componentName\" : \"componentName\", \"componentVersion\" : 1 }, \"type\" : \"type\", \"timeout\" : \"timeout\", \"node\" : \"node\", \"post\" : [ null, null ], \"name\" : \"name\", \"finalize\" : [ null, null ], \"parameters\" : { \"key\" : \"\" }, \"connections\" : [ { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 7, \"key\" : \"key\", \"required\" : true }, { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 7, \"key\" : \"key\", \"required\" : true } ] }, \"priority\" : 2, \"parentId\" : \"parentId\", \"executionTime\" : 5, \"input\" : { \"key\" : \"\" }, \"jobId\" : \"jobId\", \"maxRetries\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"progress\" : 7, \"taskNumber\" : 2, \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"CREATED\" }, { \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"icon\" : \"icon\", \"error\" : { \"stackTrace\" : [ \"stackTrace\", \"stackTrace\" ], \"message\" : \"message\" }, \"title\" : \"title\", \"type\" : \"type\", \"output\" : \"{}\", \"retryDelay\" : \"retryDelay\", \"retryDelayMillis\" : 4, \"id\" : \"id\", \"retryAttempts\" : 9, \"retryDelayFactor\" : 3, \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"workflowTask\" : { \"metadata\" : { \"key\" : \"\" }, \"pre\" : [ null, null ], \"destination\" : { \"componentName\" : \"componentName\", \"componentVersion\" : 1 }, \"description\" : \"description\", \"label\" : \"label\", \"source\" : { \"componentName\" : \"componentName\", \"componentVersion\" : 1 }, \"type\" : \"type\", \"timeout\" : \"timeout\", \"node\" : \"node\", \"post\" : [ null, null ], \"name\" : \"name\", \"finalize\" : [ null, null ], \"parameters\" : { \"key\" : \"\" }, \"connections\" : [ { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 7, \"key\" : \"key\", \"required\" : true }, { \"workflowNodeName\" : \"workflowNodeName\", \"componentName\" : \"componentName\", \"componentVersion\" : 7, \"key\" : \"key\", \"required\" : true } ] }, \"priority\" : 2, \"parentId\" : \"parentId\", \"executionTime\" : 5, \"input\" : { \"key\" : \"\" }, \"jobId\" : \"jobId\", \"maxRetries\" : 5, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"progress\" : 7, \"taskNumber\" : 2, \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"CREATED\" } ], \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"inputs\" : { \"key\" : \"\" }, \"lastModifiedBy\" : \"lastModifiedBy\", \"currentTask\" : 0, \"label\" : \"label\", \"error\" : { \"stackTrace\" : [ \"stackTrace\", \"stackTrace\" ], \"message\" : \"message\" }, \"priority\" : 1, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"parentTaskExecutionId\" : 6, \"webhooks\" : [ { \"type\" : \"type\", \"url\" : \"url\", \"retry\" : { \"maxAttempts\" : 6, \"multiplier\" : 7, \"initialInterval\" : 1, \"maxInterval\" : 1 } }, { \"type\" : \"type\", \"url\" : \"url\", \"retry\" : { \"maxAttempts\" : 6, \"multiplier\" : 7, \"initialInterval\" : 1, \"maxInterval\" : 1 } } ], \"id\" : \"id\", \"startDate\" : \"2000-01-23T04:56:07.000+00:00\", \"workflowId\" : \"workflowId\", \"status\" : \"CREATED\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
