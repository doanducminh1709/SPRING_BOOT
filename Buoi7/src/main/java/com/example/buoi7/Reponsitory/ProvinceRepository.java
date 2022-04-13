package com.example.buoi7.Reponsitory;

import com.example.buoi7.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository  extends JpaRepository<Province , Long> {
}
