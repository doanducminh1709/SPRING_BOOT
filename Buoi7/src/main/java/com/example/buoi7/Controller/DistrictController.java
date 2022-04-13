package com.example.buoi7.Controller;
import com.example.buoi7.Dto.DistrictDto;
import com.example.buoi7.Exception.DuplicateException;
import com.example.buoi7.Reponsitory.DistrictReponsitory;
import com.example.buoi7.Reponsitory.ProvinceRepository;
import com.example.buoi7.base.RestApiV1;
import com.example.buoi7.base.UrlConstant;
import com.example.buoi7.model.District;
import com.example.buoi7.model.Province;
import com.github.slugify.Slugify;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestApiV1
public class DistrictController {
    @Autowired
    private DistrictReponsitory districtReponsitory;

    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Slugify slugify;
    //lay tat ca
    @GetMapping(UrlConstant.District.DISTRICTS)
    public ResponseEntity<?> getAllDistrict(){
//Khai báo 1 lớp Page đẻ mình phân tách mỗi trang có số lượng object mà mình mong muốn
        Page<District> page = districtReponsitory.findAll(PageRequest.of(0 , 5));
        return ResponseEntity.status(200).body(districtReponsitory.findAll());
    }

    // tạo thêm district
    @PostMapping(UrlConstant.District.DISTRICTS)
    public ResponseEntity<?> createNewDistrict(@RequestBody DistrictDto districtDto){
     if(checkDistrictExits(districtDto.getCode())){
     throw new DuplicateException("duplicate");
     }
      Province province = getProvinceByCode(districtDto.getParentCode());
      District district = modelMapper.map(districtDto,District.class);
      district.setSlug(slugify.slugify(district.getName()));
      district.setNameWithType(district.getType() + " "+district.getName());
      district.setPathWithType(district.getNameWithType() + ", " + province.getNameWithType());
      return ResponseEntity.status(201).body(districtReponsitory.save(district));
    }

 @PatchMapping(UrlConstant.District.DISTRICT_WITH_cODE)
 public ResponseEntity<?> editDistrictByCode(@PathVariable("code") Long code ,
                                             @RequestBody DistrictDto districtDto){
        District district= getDistrictByCode(code);
        Province province = getProvinceByCode(districtDto.getParentCode());
        district.setName(districtDto.getName());
        district.setSlug(slugify.slugify(district.getName()));
        district.setNameWithType(district.getType() + ", " + district.getName());
        district.setPathWithType(district.getNameWithType() + ", " + province.getNameWithType());
        district.setParentCode(districtDto.getParentCode());
        district.setProvince(province);
         return ResponseEntity.status(201).body(districtReponsitory.save(district));
 }
 //delete
    @DeleteMapping(UrlConstant.District.DISTRICT_WITH_cODE)
    public ResponseEntity<?> DeleteDistrictByCode(@PathVariable("code") Long code){
        District district = getDistrictByCode(code);
        districtReponsitory.delete(district);
        return ResponseEntity.status(200).body(district);
    }

//lay tat ca danh sach district theoma code
    @GetMapping(UrlConstant.District.DISTRICT_WITH_cODE)
    public ResponseEntity<?> getAllDistrict(@PathVariable("code") Long code){
        return ResponseEntity.status(200).body(getDistrictByCode(code));
    }
//add collection district
    @PostMapping(UrlConstant.District.COLLECTION)
    public ResponseEntity<?> addCollectionDistrict(@RequestBody List<DistrictDto> districtDto){
        List<District> districts = new ArrayList<>();
        districtDto.forEach(item ->{
            if(checkDistrictExits(item.getCode())){
//              throw new Duplicate
            }
            Province province = getProvinceByCode(item.getParentCode());
            District district = modelMapper.map(item , District.class);
            district.setSlug(slugify.slugify(district.getName()));
            district.setNameWithType(district.getType() + "-" + district.getName());
            district.setPathWithType(district.getNameWithType() + ", " +  province.getNameWithType());
            districts.add(districtReponsitory.save(district));
            });
        return ResponseEntity.status(200).body(districts);
    }

    District getDistrictByCode (Long code){
        Optional<District> optional = districtReponsitory.findById(code);
        if (optional.isEmpty()) {
            System.out.println("");
        }
        //throw ra 1 cai exception
//        throw  new NotFound()
        return optional.get();
    }

    private Boolean checkDistrictExits(Long code){
        Optional<District> optional = districtReponsitory.findById(code);
        return optional.isPresent();
        //neu mà có tồn tại thả về tru k tt trả về false
    }
    Province getProvinceByCode (Long code){
        Optional<Province> optional = provinceRepository.findById(code);
        if (optional.isEmpty()) {
            System.out.println("");
        }
        //throw ra 1 cai exception
//        throw  new NotFound()
        return optional.get();
    }

}
