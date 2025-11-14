package com.kadir.ebabytracker.baby.repository;

import com.kadir.ebabytracker.baby.model.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyRepository extends JpaRepository<Baby,Long> {
    List<Baby> findAllByParent_Id(Long parentId);
}
