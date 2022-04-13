package com.example.btvnb7.Repository;

import com.example.btvnb7.Models.Darling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DarlingRepository extends JpaRepository<Darling , Long> {
    List<Darling> findDarlingByStatus(Integer status);
    List<Darling> findDarlingByStatusOrStatus(Integer item1, Integer item2);
}
