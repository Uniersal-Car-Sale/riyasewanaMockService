package com.bolton.riyasewana.controller;

import com.bolton.riyasewana.dto.json.CommonResponse;
import com.bolton.riyasewana.dto.json.VehicleFilterRequestDTO;
import com.bolton.riyasewana.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bolton.riyasewana.constant.ResponseCodes.OPERATION_SUCCESS;
import static com.bolton.riyasewana.constant.ResponseCodes.SUCCESS_RESPONSE;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/view-all")
    public ResponseEntity<?> getAllCustomerDetails() {
        try {
            return ResponseEntity.ok(vehicleService.getAllVehicleDetails());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<CommonResponse> filterVehicleDetails(@RequestBody VehicleFilterRequestDTO requestDTO) {
        return (requestDTO.getPage() == 0 && requestDTO.getSize() == 0) ?
                new ResponseEntity<>(new CommonResponse(OPERATION_SUCCESS, vehicleService.filterVehicleDetails(requestDTO)
                        , SUCCESS_RESPONSE), HttpStatus.OK)

                : new ResponseEntity<>(new CommonResponse(OPERATION_SUCCESS, vehicleService.filterVehicleDetailsWithPagination(requestDTO)
                , SUCCESS_RESPONSE), HttpStatus.OK);
    }
}
