package com.kadir.ebabytracker.parent.service;

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

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
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

    private ParentDto toDto(Parent parent) {
        ParentDto dto = new ParentDto();
        dto.setId(parent.getId());
        dto.setPassword(parent.getPassword());
        dto.setFullName(parent.getFullName());
        dto.setEMail(parent.getEmail());
        return dto;
    }


}
