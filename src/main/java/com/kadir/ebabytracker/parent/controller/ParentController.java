package com.kadir.ebabytracker.parent.controller;

import com.kadir.ebabytracker.baby.dto.BabyDto;
import com.kadir.ebabytracker.baby.service.BabyService;
import com.kadir.ebabytracker.parent.dto.ParentCreateRequest;
import com.kadir.ebabytracker.parent.dto.ParentDto;
import com.kadir.ebabytracker.parent.model.Parent;
import com.kadir.ebabytracker.parent.service.ParentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    private final ParentService parentService;
    private final BabyService babyService;


    public ParentController(ParentService parentService, BabyService babyService) {
        this.parentService = parentService;

        this.babyService = babyService;
    }

    @GetMapping
    public List<ParentDto> getAllParents(){
        return parentService.getAllParents();
    }

    @PostMapping
    public ParentDto createParent(@Valid @RequestBody ParentCreateRequest request){
        return parentService.createParent(request);
    }

    @GetMapping("/{id}")
    public ParentDto getParent(@PathVariable Long id){
        return parentService.getParentWithID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParent(@PathVariable Long id){
        parentService.deleteParent(id);
    }

    @GetMapping("/{id}/babies")
    public List<BabyDto> getParentBabies(@PathVariable Long id){
        return parentService.getBabiesForParent(id);

    }


}
