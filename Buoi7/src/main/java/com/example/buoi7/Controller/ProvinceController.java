package com.example.buoi7.Controller;

import com.example.buoi7.Dto.ProvinceDto;
import com.example.buoi7.Exception.DuplicateException;
import com.example.buoi7.Exception.NotFoundException;
import com.example.buoi7.Reponsitory.ProvinceRepository;
import com.example.buoi7.base.RestApiV1;
import com.example.buoi7.base.UrlConstant;
import com.example.buoi7.model.Province;
import com.github.slugify.Slugify;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestApiV1
public class ProvinceController {
@Autowired
    private ProvinceRepository provinceRepository;

@Autowired
    private ModelMapper modelMapper;

@Autowired
   private Slugify slugify;

    @GetMapping(UrlConstant.Province.PROVINCES)
    public ResponseEntity<?> getAllProvinces() {
    return ResponseEntity.status(200).body(provinceRepository.findAll());
}

@PostMapping(UrlConstant.Province.PROVINCES)
public ResponseEntity<?>createNewProvince(@RequestBody ProvinceDto provinceDto){
    if(checkProvinceExits(provinceDto.getCode())){
       throw new DuplicateException("Duplicate " + provinceDto.getCode());
    }
    Province province = modelMapper.map(provinceDto ,Province.class);//buoc nay de lay tat ca du lieu cho vao province
    province.setSlug(slugify.slugify(province.getName()));
    province.setNameWithType(province.getType() + "-" + province.getName());
return ResponseEntity.status(201).body(provinceRepository.save(province));
    }
//Lay theo ma code
@GetMapping(UrlConstant.Province.PROVINCE_WITH_CODE)
    public ResponseEntity<?> getProvince(@PathVariable("code") Long code) {
    return ResponseEntity.status(200).body(getProvinceByCode(code));
}
//sua code su dụng PatchMapping
    @PatchMapping(UrlConstant.Province.PROVINCE_WITH_CODE)
    public ResponseEntity<?> editProvinceByCode(@PathVariable("code") Long code ,
                                                @RequestBody ProvinceDto provinceDto){
     Province province = getProvinceByCode(code);
     province.setName(provinceDto.getName());
     province.setType(provinceDto.getType());
     province.setSlug(slugify.slugify(province.getName()));
     province.setNameWithType(province.getType() +" - "+ province.getName());
    return ResponseEntity.status(201).body(provinceRepository.save(province));
    }
//xoa theo ma code
    @DeleteMapping(UrlConstant.Province.PROVINCE_WITH_CODE)
    public ResponseEntity<?> deleteProvinceByCode(@PathVariable("code") Long code){
        Province province = getProvinceByCode(code);
        provinceRepository.delete(province);
        return ResponseEntity.status(200).body(province);
    }
//lay tat ca thong tin quan huyen theo ma thanh pho
    @GetMapping(UrlConstant.Province.DISTRICT_WITH_CODE_PROVINCE)
    public ResponseEntity<?> getDistrictsByProvinceCode(@PathVariable("code") Long code){
        return ResponseEntity.status(200).body(getProvinceByCode(code).getDistricts());
    }
   //them ca 1 danh sach tinh thanh pho
    @PostMapping(UrlConstant.Province.COLLECTION)
    @Transactional
    // sử dụng phương thức này có tác dụng khi mình add các phần tử
    // vào nếu bất kì 1 phần từ nào bị lỗi thì nó sẽ roll back lại  tất cả những cái j mà nó đã add vào
     public ResponseEntity<?> addListProvince(@RequestBody List<ProvinceDto> provinceDtoList){
        List<Province> provinces = new ArrayList<>();
        provinceDtoList.forEach(item ->{
            if(checkProvinceExits(item.getCode())){
             throw new DuplicateException("duplicate exception ");
            }
            Province province = modelMapper.map(item ,Province.class);
            province.setSlug(slugify.slugify(province.getName()));
            province.setNameWithType(province.getType() + "-" + province.getName());
            Province newProvince =  provinceRepository.save(province);
            provinces.add(newProvince);
        });
        return ResponseEntity.status(200).body(provinces);
    }

//neu nhung phuong thuc dung nhiều va lap lai thì mình sẽ tách riêng ra 1 hàm
    Province getProvinceByCode (Long code){
        Optional<Province> optional = provinceRepository.findById(code);
        if (optional.isEmpty()) {
            throw new NotFoundException("not found exception");
        }
        return optional.get();
    }

    private Boolean checkProvinceExits(Long code){
        Optional<Province> optional = provinceRepository.findById(code);
        return optional.isPresent();
    }
}
