package com.example.buoi7.Reponsitory;

import com.example.buoi7.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictReponsitory extends JpaRepository<District , Long> {

}
