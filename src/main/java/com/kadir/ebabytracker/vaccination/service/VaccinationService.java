package com.kadir.ebabytracker.vaccination.service;

import com.kadir.ebabytracker.vaccination.dto.VaccinationCreateRequest;
import com.kadir.ebabytracker.vaccination.dto.VaccinationDto;
import com.kadir.ebabytracker.vaccination.dto.VaccinationUpdateRequest;


import java.util.List;

public interface VaccinationService {

    VaccinationDto createVaccination(VaccinationCreateRequest request);

    List<VaccinationDto> getAllVaccinations();

    VaccinationDto getVaccinationWithID(Long id);

    void deleteVaccination (Long id);

    // Eğer bebeğe göre listeleme istiyorsak:
    List<VaccinationDto> getVaccinationsForBaby(Long babyId);

    VaccinationDto updateVaccination(Long id, VaccinationUpdateRequest request);

}
