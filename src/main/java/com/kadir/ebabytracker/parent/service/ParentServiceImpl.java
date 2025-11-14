package com.kadir.ebabytracker.parent.service;

import com.kadir.ebabytracker.baby.dto.BabyDto;
import com.kadir.ebabytracker.baby.model.Baby;
import com.kadir.ebabytracker.baby.repository.BabyRepository;
import com.kadir.ebabytracker.parent.dto.ParentCreateRequest;
import com.kadir.ebabytracker.parent.dto.ParentDto;
import com.kadir.ebabytracker.parent.model.Parent;
import com.kadir.ebabytracker.parent.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentServiceImpl implements ParentService{

    private final ParentRepository parentRepository;
    private final BabyRepository babyRepository;

    public ParentServiceImpl(ParentRepository parentRepository, BabyRepository babyRepository) {
        this.parentRepository = parentRepository;
        this.babyRepository = babyRepository;
    }


    @Override
    public ParentDto createParent(ParentCreateRequest request) {
        Parent parent = new Parent();
        parent.setEmail(request.getEmail());
        parent.setPassword(request.getPassword());
        parent.setFullName(request.getFullName());

        Parent saved = parentRepository.save(parent);

        return toDto(saved);
    }

    @Override
    public List<ParentDto> getAllParents() {
        return parentRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParentDto getParentWithID(Long id){
        //Optional <Baby> babyOptional = babyRepository.findById(id);
        Parent parent =parentRepository.findById(id).orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));

        return  toDto(parent);
    }

    @Override
    public void deleteParent(Long id){
        parentRepository.deleteById(id);
    }

    @Override
    public List <BabyDto> getBabiesForParent(Long parentId){

        parentRepository.findById(parentId).orElseThrow(()-> new RuntimeException("Parent not found"));

        List <Baby> babies =babyRepository.findAllByParent_Id(parentId);

        return babies.stream()
                .map(this::toDto)
                .toList();
    }

    private ParentDto toDto(Parent parent) {
        ParentDto dto = new ParentDto();
        dto.setId(parent.getId());
        dto.setPassword(parent.getPassword());
        dto.setFullName(parent.getFullName());
        dto.setEMail(parent.getEmail());

        return dto;
    }

    private BabyDto toDto(Baby baby) {
        BabyDto dto = new BabyDto();
        dto.setId(baby.getId());
        dto.setName(baby.getName());
        dto.setGender(baby.getGender());
        dto.setBirthDay(baby.getBirthDay());
        dto.setWeight(baby.getWeight());
        dto.setHeight(baby.getHeight());
        dto.setNotes(baby.getNotes());
        return dto;
    }

}
