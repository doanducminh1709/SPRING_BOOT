package com.hit.baiktraweb.Controller;

import com.hit.baiktraweb.Base.RestApiV1;
import com.hit.baiktraweb.Base.UrlContant;
import com.hit.baiktraweb.Models.Address;
import com.hit.baiktraweb.Models.Darling;
import com.hit.baiktraweb.Repository.AddressRepository;
import com.hit.baiktraweb.Repository.DarlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@RestApiV1
public class AddressController {
    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public DarlingRepository darlingRepository;

    @DeleteMapping(UrlContant.ADDRESS.ADDRESS_WITH_DARLING_ID)
    public ResponseEntity<?> DeleteAddressByCode(@PathVariable("code") Long code){
      Address addres = getAddressByCode(code);
        addressRepository.delete(addres);
        return ResponseEntity.status(200).body(addres);
    }
    private Boolean checkDistrictExits(Long code){
        Optional<Darling> optional = darlingRepository.findById(code);
        return optional.isPresent();
    }
    Darling getAddressByCode (Long code){
        Optional<Address> optional = addressRepository.findById(code);
        if (optional.isEmpty()) {
            System.out.println("");
        }
        return optional.get();
    }

}
