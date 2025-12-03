package com.kadir.ebabytracker.baby.service;


import com.kadir.ebabytracker.baby.dto.BabyCreateRequest;
import com.kadir.ebabytracker.baby.dto.BabyDto;
import com.kadir.ebabytracker.baby.dto.BabyUpdateRequest;
import com.kadir.ebabytracker.baby.model.Baby;
import com.kadir.ebabytracker.baby.repository.BabyRepository;
import com.kadir.ebabytracker.common.exception.EntityNotFoundException;
import com.kadir.ebabytracker.parent.model.Parent;
import com.kadir.ebabytracker.parent.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BabyServiceImpl implements BabyService {

    private final BabyRepository babyRepository;
    private final ParentRepository parentRepository;



    public BabyServiceImpl(BabyRepository babyRepository, ParentRepository parentRepository){
        this.babyRepository = babyRepository;
        this.parentRepository = parentRepository;
    }



    @Override
    public BabyDto createBaby(BabyCreateRequest request) {

        Parent parent = parentRepository.findById(request.parentId()).orElseThrow(() -> new EntityNotFoundException("Parent" ,request.parentId()));
        Baby baby = new Baby();
        baby.setName(request.name());
        baby.setGender(request.gender());
        baby.setBirthDay(request.birthDay());
        baby.setNotes(request.notes());
        baby.setHeight(request.height());
        baby.setWeight(request.weight());
        baby.setParent(parent);


        Baby saved = babyRepository.save(baby);

        return toDto(saved);
    }


    @Override
    public List<BabyDto> getAllBabies() {
        return babyRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public BabyDto getBabyWithID(Long id){
        //Optional <Baby> babyOptional = babyRepository.findById(id);
        Baby baby =babyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Baby", id));

        return  toDto(baby);
    }

    @Override
    public void deleteBaby (Long id){
        babyRepository.deleteById(id);
    }

    @Override
    public BabyDto updateBaby(Long id, BabyUpdateRequest updateRequest){
        Baby baby = babyRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Baby",id));
        baby.setName(updateRequest.name());
        baby.setGender(updateRequest.gender());
        baby.setBirthDay(updateRequest.birthDay());
        baby.setNotes(updateRequest.notes());
        baby.setHeight(updateRequest.height());
        baby.setWeight(updateRequest.weight());

        Baby updateBaby = babyRepository.save(baby);
        return toDto(updateBaby);
    }

    @Override
    public List <BabyDto> getBabiesForParent(Long parentId){

        Parent parent = parentRepository.findById(parentId).orElseThrow(()-> new EntityNotFoundException("Parent", parentId));
        List <Baby> babies =babyRepository.findAllByParent_Id(parentId);
        return babies.stream()
                .map(this::toDto)
                .toList();
    }



    private BabyDto toDto(Baby baby) {
        return new BabyDto(
            baby.getId(),
            baby.getName(),
            baby.getGender(),
            baby.getNotes(),
            baby.getBirthDay(),
            baby.getWeight(),
            baby.getHeight()
        );
    }


}
