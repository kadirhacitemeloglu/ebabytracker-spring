package com.kadir.ebabytracker.baby.service;


import com.kadir.ebabytracker.baby.dto.BabyCreateRequest;
import com.kadir.ebabytracker.baby.dto.BabyDto;
import com.kadir.ebabytracker.baby.dto.BabyUpdateRequest;
import com.kadir.ebabytracker.baby.model.Baby;
import com.kadir.ebabytracker.baby.repository.BabyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BabyServiceImpl implements BabyService {

    private final BabyRepository babyRepository;

    public BabyServiceImpl(BabyRepository babyRepository){
        this.babyRepository = babyRepository;
    }


    @Override
    public BabyDto createBaby(BabyCreateRequest request) {
        Baby baby = new Baby();
        baby.setName(request.getName());
        baby.setGender(request.getGender());
        baby.setBirthDay(request.getBirthDay());
        baby.setNotes(request.getNotes());
        baby.setHeight(request.getHeight());
        baby.setWeight(request.getWeight());

        Baby saved = babyRepository.save(baby);

        return toDto(saved);
    }


    @Override
    public List<BabyDto> getAllBabies() {
        return babyRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BabyDto getBabyWithID(Long id){
        //Optional <Baby> babyOptional = babyRepository.findById(id);
        Baby baby =babyRepository.findById(id).orElseThrow(() -> new RuntimeException("Baby not found with id: " + id));

        return  toDto(baby);
    }

    @Override
    public void deleteBaby (Long id){
        babyRepository.deleteById(id);
    }

    @Override
    public BabyDto updateBaby(Long id, BabyUpdateRequest updateRequest){
        Baby baby = babyRepository.findById(id).orElseThrow(()-> new RuntimeException("Baby not found with id: " + id));
        baby.setName(updateRequest.getName());
        baby.setGender(updateRequest.getGender());
        baby.setBirthDay(updateRequest.getBirthDay());
        baby.setNotes(updateRequest.getNotes());
        baby.setHeight(updateRequest.getHeight());
        baby.setWeight(updateRequest.getWeight());

        Baby updateBaby = babyRepository.save(baby);
        return toDto(updateBaby);
    }

    private BabyDto toDto(Baby baby) {
        BabyDto dto = new BabyDto();
        dto.setId(baby.getId());
        dto.setName(baby.getName());
        dto.setGender(baby.getGender());
        dto.setNotes(baby.getNotes());
        dto.setBirthDay(baby.getBirthDay());
        dto.setWeight(baby.getWeight());
        dto.setHeight(baby.getHeight());
        return dto;
    }


}
