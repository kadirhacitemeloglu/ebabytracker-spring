package com.kadir.ebabytracker.baby.service;

import com.kadir.ebabytracker.baby.dto.BabyCreateRequest;
import com.kadir.ebabytracker.baby.dto.BabyDto;
import com.kadir.ebabytracker.baby.dto.BabyUpdateRequest;


import java.util.List;

public interface BabyService {

    BabyDto createBaby(BabyCreateRequest request);

    List<BabyDto> getAllBabies();

    BabyDto getBabyWithID(Long id);

    void  deleteBaby (Long id);


    BabyDto updateBaby(Long id, BabyUpdateRequest updateRequest);


    List <BabyDto> getBabiesForParent(Long parentId);
}
