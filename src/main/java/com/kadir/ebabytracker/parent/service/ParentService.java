package com.kadir.ebabytracker.parent.service;

import com.kadir.ebabytracker.baby.dto.BabyDto;
import com.kadir.ebabytracker.parent.dto.ParentCreateRequest;
import com.kadir.ebabytracker.parent.dto.ParentDto;

import java.util.List;

public interface ParentService {

    ParentDto createParent(ParentCreateRequest request);

    List<ParentDto> getAllParents();

    ParentDto getParentWithID(Long id);

    void deleteParent(Long id);

    List<BabyDto> getBabiesForParent(Long parentId);
}
