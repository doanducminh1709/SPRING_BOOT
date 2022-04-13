package com.example.btvnb7.Controller;
import com.example.btvnb7.Base.Constant;
import com.example.btvnb7.Base.RestApi;
import com.example.btvnb7.Dto.AddressDto;
import com.example.btvnb7.Services.Imp.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestApi
public class AddressController {

    @Autowired
    AddressServiceImp addressServiceImp;

    @PostMapping(Constant.Address.POST_ADDRESS)
    public ResponseEntity<?> addAddressGf(@PathVariable("darlingId") Long darlingId , AddressDto addressDto){
        return ResponseEntity.status(200).body(addressServiceImp.addAddressGf(darlingId , addressDto));
    }

    @PatchMapping(Constant.Address.ADDRESSES_BY_DARLING_ID)
    public ResponseEntity<?> EditInfoAddressGf(@PathVariable("darlingId") Long darlingId ,
                                               @PathVariable("id") Long id , AddressDto addressDto){
        return ResponseEntity.status(200).body(addressServiceImp.EditInfoAddressGf(darlingId , id , addressDto));
    }

    @DeleteMapping(Constant.Address.ADDRESSES_BY_DARLING_ID)
    public ResponseEntity<?> DeleteAddressGf(@PathVariable("darlingId") Long darlingId ,
                                             @PathVariable("id")Long id){
        return ResponseEntity.status(200).body(addressServiceImp.DeleteAddressGf(darlingId , id));
    }

}
