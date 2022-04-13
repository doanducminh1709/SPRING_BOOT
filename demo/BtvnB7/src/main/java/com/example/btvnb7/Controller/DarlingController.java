package com.example.btvnb7.Controller;

import com.example.btvnb7.Base.Constant;
import com.example.btvnb7.Base.RestApi;
import com.example.btvnb7.Dto.DarlingDto;
import com.example.btvnb7.Repository.DarlingRepository;
import com.example.btvnb7.Services.Imp.DarlingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestApi
public class DarlingController {

    @Autowired
    DarlingServiceImp darlingServiceImp;

    @Autowired
    DarlingRepository darlingRepository;

  @GetMapping(Constant.Darling.DARLINGS)
    public ResponseEntity<?> getAllList(){
      return ResponseEntity.status(200).body(darlingServiceImp.GetAllGirlFriend());
  }

  @GetMapping(Constant.Darling.CURRENT)
    public ResponseEntity<?> GetAllGirlFriendParent(){
      return ResponseEntity.status(200).body(darlingRepository.findDarlingByStatusOrStatus(1 ,2));
  }

  @GetMapping(Constant.Darling.CURRENT)
    public ResponseEntity<?> getAllGfSulking(@RequestParam(name = "status") Integer status){
      return ResponseEntity.status(200).body(darlingServiceImp.getAllGfSulking(status));
  }

  @GetMapping(Constant.Darling.DARLING_BY_ID)
  public ResponseEntity<?>GetGirlFriendById(@PathVariable("id") Long id){
    return ResponseEntity.status(200).body(darlingServiceImp.GetGirlFriendById(id));
  }

  @PostMapping(Constant.Darling.DARLINGS)
  public ResponseEntity<?> AddGirlFriend(DarlingDto darlingDto){
    return ResponseEntity.status(200).body(darlingServiceImp.AddGirlFriend(darlingDto));
  }

  @PatchMapping(Constant.Darling.DARLING_BY_ID)
  public ResponseEntity<?> EditInfoGfById(DarlingDto darlingDto , @PathVariable("id") Long id){
    return ResponseEntity.status(200).body(darlingServiceImp.EditInfoGfById(darlingDto , id));
  }
  @DeleteMapping(Constant.Darling.DARLING_BY_ID)
  public ResponseEntity<?> ChangeStatus(@PathVariable("id") Long id){
    return ResponseEntity.status(200).body(darlingServiceImp.ChangeStatus(id));
  }
  @GetMapping(Constant.Darling.DARLING_BY_ID_ADDRESSES)
  public ResponseEntity<?> getListAddressGf(@PathVariable("id") Long id){
    return ResponseEntity.status(200).body(darlingServiceImp.getListAddressGf(id));
  }
  @GetMapping(Constant.Darling.DARLING_BY_ID_ADDRESSES)
  public ResponseEntity<?> getSameGrProvince(@PathVariable("id") Long id , @RequestParam("p") String p){
    return ResponseEntity.status(200).body(darlingServiceImp.getSameGrProvince(id , p));
  }
}
