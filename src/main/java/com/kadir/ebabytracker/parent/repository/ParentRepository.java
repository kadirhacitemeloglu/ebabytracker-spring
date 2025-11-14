package com.kadir.ebabytracker.parent.repository;

import com.kadir.ebabytracker.parent.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentRepository extends JpaRepository <Parent,Long> {
}
