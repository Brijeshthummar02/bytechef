/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.embedded.configuration.web.rest;

import com.bytechef.embedded.configuration.web.rest.model.AppEventModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-19T13:50:27.479731+01:00[Europe/Zagreb]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "app-event", description = "The Embedded App Event Internal API")
public interface AppEventApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /app-events : Create a new app event
     * Create a new app event.
     *
     * @param appEventModel  (required)
     * @return The app event id. (status code 200)
     */
    @Operation(
        operationId = "createAppEvent",
        summary = "Create a new app event",
        description = "Create a new app event.",
        tags = { "app-event" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The app event id.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/app-events",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Long> createAppEvent(
        @Parameter(name = "AppEventModel", description = "", required = true) @Valid @RequestBody AppEventModel appEventModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /app-events/{id} : Delete an app event
     * Delete an app event.
     *
     * @param id The id of an app event. (required)
     * @return Successful operation. (status code 204)
     */
    @Operation(
        operationId = "deleteAppEvent",
        summary = "Delete an app event",
        description = "Delete an app event.",
        tags = { "app-event" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/app-events/{id}"
    )
    
    default ResponseEntity<Void> deleteAppEvent(
        @Parameter(name = "id", description = "The id of an app event.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /app-events/{id} : Get an app event by id
     * Get an app event by id.
     *
     * @param id The id of an app event. (required)
     * @return The app event object. (status code 200)
     */
    @Operation(
        operationId = "getAppEvent",
        summary = "Get an app event by id",
        description = "Get an app event by id.",
        tags = { "app-event" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The app event object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AppEventModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/app-events/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<AppEventModel> getAppEvent(
        @Parameter(name = "id", description = "The id of an app event.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"schema\" : \"schema\", \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /app-events : Get app events
     * Get app events.
     *
     * @return The list of app events. (status code 200)
     */
    @Operation(
        operationId = "getAppEvents",
        summary = "Get app events",
        description = "Get app events.",
        tags = { "app-event" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of app events.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AppEventModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/app-events",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<AppEventModel>> getAppEvents(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"schema\" : \"schema\", \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 }, { \"schema\" : \"schema\", \"__version\" : 6, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"name\" : \"name\", \"id\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /app-events/{id} : Update an existing app event
     * Update an existing app event.
     *
     * @param id The id of an app event. (required)
     * @param appEventModel  (required)
     * @return Successful operation. (status code 204)
     */
    @Operation(
        operationId = "updateAppEvent",
        summary = "Update an existing app event",
        description = "Update an existing app event.",
        tags = { "app-event" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/app-events/{id}",
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> updateAppEvent(
        @Parameter(name = "id", description = "The id of an app event.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "AppEventModel", description = "", required = true) @Valid @RequestBody AppEventModel appEventModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
