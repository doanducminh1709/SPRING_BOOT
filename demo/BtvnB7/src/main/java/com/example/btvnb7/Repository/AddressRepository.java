package com.example.btvnb7.Repository;

import com.example.btvnb7.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address , Long> {
   List<Address> findAddressByDarlingId(Long DarlingId);
}
