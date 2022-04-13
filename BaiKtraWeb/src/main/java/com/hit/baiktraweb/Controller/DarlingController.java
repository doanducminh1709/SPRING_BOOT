package com.hit.baiktraweb.Controller;

import com.hit.baiktraweb.Base.RestApiV1;
import com.hit.baiktraweb.Base.UrlContant;
import com.hit.baiktraweb.Dto.DarlingDto;
import com.hit.baiktraweb.Models.Darling;
import com.hit.baiktraweb.Repository.AddressRepository;
import com.hit.baiktraweb.Repository.DarlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestApiV1
public class DarlingController {
    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public DarlingRepository darlingRepository;

    @GetMapping(UrlContant.Darling.DARLINGS)
    public ResponseEntity<?> getAllGirl(){
        return ResponseEntity.status(200).body(darlingRepository.findAll());
    }

//
//    @GetMapping(UrlContant.Darling.DARLINGS_CURRENT)
//    public ResponseEntity<?> getAllGirlPerent(@RequestBody Darling darling){
//        List<Darling> darlings = darlingRepository.findAll();
//
//    }

    @GetMapping(UrlContant.Darling.DARLINGS_WITH_ID)
    public ResponseEntity<?> GetALLGirlById(@RequestPart("id") Long id){
    return ResponseEntity.status(200).body(darlingRepository.findById(id));
    }

    @PostMapping(UrlContant.Darling.DARLINGS)
    public ResponseEntity<?>addGirlFriend(@RequestBody DarlingDto darlingDto){
        Darling darling = new Darling();
        darling.setName(darlingDto.getName());
        darling.setPhone(darlingDto.getPhone());
        darling.setFavorite(darling.getFavorite());
        darling.setEmail(darling.getEmail());
        return ResponseEntity.status(200).body(darlingRepository.save(darling));
    }

    @PatchMapping(UrlContant.Darling.DARLINGS_WITH_ID)
    public ResponseEntity<?> EditDarlingByCode(@PathVariable("code") Long code ,
                                                @RequestBody DarlingDto darlingDto){
        Darling darling = getDarlingByCode(code);
        darling.setName(darlingDto.getName());
        darling.setPhone(darlingDto.getPhone());
        darling.setFavorite(darling.getFavorite());
        darling.setEmail(darling.getEmail());
        return ResponseEntity.status(201).body(darlingRepository.save(darling));
    }
    //delete
    @DeleteMapping(UrlContant.Darling.DARLINGS_WITH_ID)
    public ResponseEntity<?> DeleteDarlingByCode(@PathVariable("code") Long code){
        Darling darling = getDarlingByCode(code);
        darlingRepository.delete(darling);
        return ResponseEntity.status(200).body(darling);
    }
    private Boolean checkDistrictExits(Long code){
        Optional<Darling> optional = darlingRepository.findById(code);
        return optional.isPresent();
    }
     Darling getDarlingByCode (Long code){
        Optional<Darling> optional = darlingRepository.findById(code);
        if (optional.isEmpty()) {
            System.out.println("");
        }
        return optional.get();
    }

}
