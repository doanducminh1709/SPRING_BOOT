package com.example.chuabtvnb7.Controller;

import com.example.chuabtvnb7.Dto.AddressDTO;
import com.example.chuabtvnb7.Services.Imp.AddressImp;
import com.example.chuabtvnb7.Services.Imp.DarlingImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    DarlingImp darlingImp;

    @Autowired
    AddressImp addressImp;

    @PostMapping("/{darlingId}")
    public ResponseEntity<?> AddAddress(@PathVariable("darlingId") Long darlingId, AddressDTO addressDTO) {
        return ResponseEntity.status(200).body(addressImp.addInformation(darlingId, addressDTO));
    }

    @PatchMapping("/{darlingId}/{id}")
    public ResponseEntity<?> editAddress(@PathVariable("darlingId") Long darlingId,
                                         @PathVariable("id") Long id, AddressDTO addressDTO) {
        return ResponseEntity.status(201).body(addressImp.editInformation(id, darlingId, addressDTO));

    }

    @DeleteMapping("/{darlingId}/{id}")
    public ResponseEntity<?> deleteDarling(@PathVariable("darlingId") Long darlingId,
                                             @PathVariable("id") Long id) {
        return ResponseEntity.status(201).body(addressImp.deleteAddress(darlingId, id));
    }

}