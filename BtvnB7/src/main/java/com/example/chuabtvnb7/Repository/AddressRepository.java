package com.example.chuabtvnb7.Repository;
import com.example.chuabtvnb7.Models.Address;
import com.example.chuabtvnb7.Models.Darling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
//   Address findAddressBy(String province); //?? Lôĩ vì khô
   Address findAddressByName(String province);
   Set<Address> findAllByDarling(Darling darling);
}
