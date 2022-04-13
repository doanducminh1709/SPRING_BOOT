package com.example.chuabtvnb7.Controller;

import com.example.chuabtvnb7.Dto.DarlingDTO;
import com.example.chuabtvnb7.Services.Imp.DarlingImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/darlings")
public class DarlingController {
    @Autowired
    DarlingImp darlingImp;


//
//    @GetMapping("")
//    public ResponseEntity<?>getListDarling(){
//        return ResponseEntity.status(200).body(darlingImp.getAllDarlings());
//    }

    @GetMapping("/current")
    public ResponseEntity<?> getAllListCurrent() {
        return ResponseEntity.status(200).body(darlingImp.getAllDarlingByCurrent());
    }

    @GetMapping
    public ResponseEntity<?> getAllListGfAnnoy(@RequestParam(name = "status", required = false) Integer status) {
        if (status != null) {
            return ResponseEntity.status(200).body(darlingImp.getAllDarlingAnnoy(status));
        }
        return ResponseEntity.status(200).body(darlingImp.getAllDarlings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDarlingById(@PathVariable("id") Long id) {
        return ResponseEntity.status(200).body(darlingImp.getDarlingById(id));
    }

    @PostMapping
    public ResponseEntity<?> AddNewDarling(DarlingDTO darlingDTO) {
        return ResponseEntity.status(200).body(darlingImp.addNewDarling(darlingDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editDarling(@PathVariable("id") Long id,
                                         DarlingDTO darlingDTO) {
        return ResponseEntity.status(200).body(darlingImp.editDarlingById(id, darlingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> changeStatusDarling(@PathVariable("id") Long id) {
        return ResponseEntity.status(200).body(darlingImp.deleteDarling(id));
    }

    //gộp thành 1 vì trùng path
//    @GetMapping("/{id}/addresses")
//    public ResponseEntity<?> getAllDarlingByDarling(@PathVariable("id") Long id){
//        return ResponseEntity.status(200).body(darlingImp.getAllAddressByDarling(id));
//    }
    @GetMapping("/{id}/addresses")
    public ResponseEntity<?> getAllDarlingSimilarProvince(@PathVariable("id") Long id,
                                                          @RequestParam(value = "province", required = false) String province) {
        return ResponseEntity.status(200).body(darlingImp.getAllDarlingSimilarProvince(id, province));
    }


}
