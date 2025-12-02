package com.kadir.ebabytracker.vaccination.controller;

import com.kadir.ebabytracker.vaccination.dto.VaccinationCreateRequest;
import com.kadir.ebabytracker.vaccination.dto.VaccinationDto;
import com.kadir.ebabytracker.vaccination.dto.VaccinationUpdateRequest;
import com.kadir.ebabytracker.vaccination.service.VaccinationService;
import com.kadir.ebabytracker.vaccination.service.VaccinationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
public class VaccinationController {
    private final VaccinationService vaccinationService;

    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @PostMapping
    public VaccinationDto createVaccination(@Valid @RequestBody VaccinationCreateRequest request){
        return vaccinationService.createVaccination(request);
    }

    @GetMapping
    public List<VaccinationDto> getAllVaccination(){
        return vaccinationService.getAllVaccinations();
    }

    @GetMapping("/{id}")
    public VaccinationDto getVaccinationWithID (@PathVariable Long id){
        return vaccinationService.getVaccinationWithID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVaccination(@PathVariable Long id){
        vaccinationService.deleteVaccination(id);
    }

    @GetMapping("/baby/{babyId}")
    public List<VaccinationDto> getByBaby(@PathVariable Long babyId){
        return vaccinationService.getVaccinationsForBaby(babyId);
    }

    @PutMapping("/{id}")
    public VaccinationDto updateVaccination(@PathVariable Long id,
                          @Valid @RequestBody VaccinationUpdateRequest updateRequest){
        return vaccinationService.updateVaccination(id,updateRequest);
    }
}
