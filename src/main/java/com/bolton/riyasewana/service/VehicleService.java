package com.bolton.riyasewana.service;

import com.bolton.riyasewana.dto.VehicleDTO;
import com.bolton.riyasewana.dto.json.VehicleFilterRequestDTO;

import java.util.List;
import org.springframework.data.domain.Page;

public interface VehicleService {

    List<VehicleDTO> filterVehicleDetails(VehicleFilterRequestDTO requestDTO);

    Page<VehicleDTO> filterVehicleDetailsWithPagination(VehicleFilterRequestDTO requestDTO);

    List<VehicleDTO> getAllVehicleDetails();
}
