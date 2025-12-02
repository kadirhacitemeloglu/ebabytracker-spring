package com.kadir.ebabytracker.baby.controller;

import com.kadir.ebabytracker.baby.dto.BabyCreateRequest;
import com.kadir.ebabytracker.baby.dto.BabyDto;
import com.kadir.ebabytracker.baby.dto.BabyUpdateRequest;
import com.kadir.ebabytracker.baby.service.BabyService;
import com.kadir.ebabytracker.vaccination.dto.VaccinationDto;
import com.kadir.ebabytracker.vaccination.service.VaccinationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/babies")
public class BabyController {
    private final BabyService babyService;
    private final VaccinationService vaccinationService;

    public BabyController(BabyService babyService, VaccinationService vaccinationService) {
        this.babyService = babyService;
        this.vaccinationService = vaccinationService;
    }

    @GetMapping
    public List<BabyDto> getallBabies(){
        return babyService.getAllBabies();
    }

    @PostMapping
    public BabyDto createBaby(@Valid @RequestBody BabyCreateRequest request){
        return babyService.createBaby(request);
    }

    @GetMapping("/{id}")
    public BabyDto getBaby(@PathVariable Long id){
        return babyService.getBabyWithID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBaby(@PathVariable Long id){
        babyService.deleteBaby(id);
    }

    @PutMapping("/{id}")
    public BabyDto updateBaby(@PathVariable Long id,
                              @Valid @RequestBody BabyUpdateRequest updateRequest){
        return babyService.updateBaby(id, updateRequest);
    }

    @GetMapping("/{id}/vaccinations")
    public List<VaccinationDto> getBabiesVaccinations(@PathVariable Long id){
        return vaccinationService.getVaccinationsForBaby(id);
    }
}
