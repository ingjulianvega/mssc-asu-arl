package ingjulianvega.ximic.msscasuarl.web.controller;

import ingjulianvega.ximic.msscasuarl.exception.ArlException;
import ingjulianvega.ximic.msscasuarl.web.model.Arl;
import ingjulianvega.ximic.msscasuarl.web.model.ArlDto;
import ingjulianvega.ximic.msscasuarl.web.model.ArlList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface ArlI {

    @Operation(summary = "Endpoint to get the list of ARL", description = "Returns a list of ARL", tags = {"ARL"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = ArlList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ArlException.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ArlException.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ArlList> get();


    @Operation(summary = "Endpoint to get the information of an ARL given the id", description = "Returns an ARL", tags = {"ARL"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = ArlDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ArlException.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ArlException.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<ArlDto> getById(@Parameter(in = ParameterIn.PATH, description = "The ARL id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

    @Operation(summary = "Endpoint to create an ARL", description = "Creates a new ARL", tags = {"ARL"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ArlException.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ArlException.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "Name of the new ARL", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Arl body);


    @Operation(summary = "Endpoint to update the information of an ARL given the id", description = "Updates an ARL", tags = {"ARL"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ArlException.class))),

            @ApiResponse(responseCode = "500", description = "500 - error de server, it'll show a generic user message", content = @Content(schema = @Schema(implementation = ArlException.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The ARL id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "Name of the new ARL", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Arl body);


    @Operation(summary = "Endpoint to delete an ARL", description = "Deletes an ARL", tags = {"ARL"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ArlException.class))),

            @ApiResponse(responseCode = "500", description = "500 - error de server, it'll show a generic user message", content = @Content(schema = @Schema(implementation = ArlException.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The ARL id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);


}
