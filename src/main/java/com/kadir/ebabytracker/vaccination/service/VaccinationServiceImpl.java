package com.kadir.ebabytracker.vaccination.service;


import com.kadir.ebabytracker.common.exception.EntityNotFoundException;
import com.kadir.ebabytracker.baby.model.Baby;
import com.kadir.ebabytracker.baby.repository.BabyRepository;

import com.kadir.ebabytracker.common.exception.InvalidVaccinationDateException;
import com.kadir.ebabytracker.vaccination.dto.VaccinationCreateRequest;
import com.kadir.ebabytracker.vaccination.dto.VaccinationDto;
import com.kadir.ebabytracker.vaccination.dto.VaccinationUpdateRequest;
import com.kadir.ebabytracker.vaccination.model.Vaccination;
import com.kadir.ebabytracker.vaccination.repository.VaccinationRepository;
import org.springframework.stereotype.Service;




import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaccinationServiceImpl implements VaccinationService {

    private final VaccinationRepository vaccinationRepository;
    private final BabyRepository babyRepository;


    public VaccinationServiceImpl(VaccinationRepository vaccinationRepository,BabyRepository babyRepository){

        this.vaccinationRepository = vaccinationRepository;
        this.babyRepository = babyRepository;
    }


    @Override
    public VaccinationDto createVaccination(VaccinationCreateRequest request) {



        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new EntityNotFoundException("Baby",request.babyId()));


        Vaccination vaccination = new Vaccination();

        if(request.vaccinationDate().isAfter(LocalDate.now())){
            throw new InvalidVaccinationDateException(request.vaccinationDate());
        }

        vaccination.setVaccineName(request.vaccineName());
        vaccination.setVaccinationDate(request.vaccinationDate());
        vaccination.setDoseNumber(request.doseNumber());
        vaccination.setNotes(request.notes());
        vaccination.setBaby(baby);

        Vaccination saved = vaccinationRepository.save(vaccination);

        return toDto(saved);
    }



    @Override
    public List<VaccinationDto> getAllVaccinations() {
        return vaccinationRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public VaccinationDto getVaccinationWithID(Long id) {
        Vaccination vaccination = vaccinationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vaccination", id));
        return toDto(vaccination);
    }

    @Override
    public void deleteVaccination(Long id) {
        vaccinationRepository.deleteById(id);
    }

    @Override
    public List<VaccinationDto> getVaccinationsForBaby(Long babyId) {
        List<Vaccination> vaccinations = vaccinationRepository.findAllByBaby_Id(babyId);
        return vaccinations.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public VaccinationDto updateVaccination(Long id, VaccinationUpdateRequest updateRequest) {
        Vaccination vaccination =vaccinationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vaccination", id));
        vaccination.setVaccinationDate(updateRequest.vaccinationDate());
        vaccination.setNotes(updateRequest.notes());
        vaccination.setDoseNumber(updateRequest.doseNumber());

        Vaccination updateVaccination = vaccinationRepository.save(vaccination);

        return toDto(updateVaccination);

    }

    private VaccinationDto toDto(Vaccination vaccination) {
        return new VaccinationDto(
                vaccination.getId(),
                vaccination.getVaccineName(),
                vaccination.getVaccinationDate(),
                vaccination.getDoseNumber(),
                vaccination.getNotes(),
                vaccination.getBaby().getId()
        );
    }

}
