package com.example.chuabtvnb7.Repository;

import com.example.chuabtvnb7.Models.Address;
import com.example.chuabtvnb7.Models.Darling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DarlingRepository extends JpaRepository<Darling, Long> {
    Set<Darling> findAllByStatusNot(Integer status);
    Darling findDarlingByStatus(Integer status);
    Darling findAllById(Long idDarling);
    Darling findDarlingByAddress(Address address);
}
