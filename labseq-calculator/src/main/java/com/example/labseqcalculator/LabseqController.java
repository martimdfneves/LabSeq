package com.example.labseqcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Labseq Controller", description = "Endpoints for Labseq calculations")
@RequestMapping("/labseq")
public class LabseqController {

    @Autowired
    private LabseqService labseqService;

    @GetMapping("/{n}")
    @ApiOperation(value = "Get Labseq Value", notes = "Get the Labseq value for a given index.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved Labseq value"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Labseq value not found"),
    })
    public String getLabseqValue(@PathVariable int n) {
        if (n < 0){
            return "n must be a non-negative value";
        }
        return labseqService.calculateLabseq(n);
    }
}