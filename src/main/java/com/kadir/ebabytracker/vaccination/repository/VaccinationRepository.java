package com.kadir.ebabytracker.vaccination.repository;

import com.kadir.ebabytracker.baby.model.Baby;
import com.kadir.ebabytracker.vaccination.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination,Long> {
    List<Vaccination> findAllByBaby_Id(Long babyId);


}
