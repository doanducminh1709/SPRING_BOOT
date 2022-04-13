package com.example.btvnb7.Services.Imp;
import com.example.btvnb7.Dto.DarlingDto;
import com.example.btvnb7.Exception.NotFoundException;
import com.example.btvnb7.Models.Address;
import com.example.btvnb7.Models.Darling;
import com.example.btvnb7.Repository.AddressRepository;
import com.example.btvnb7.Repository.DarlingRepository;
import com.example.btvnb7.Services.DarlingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class DarlingServiceImp implements DarlingService {
    @Autowired
    DarlingRepository darlingRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Darling> GetAllGirlFriend() {
        List<Darling> darlingList = darlingRepository.findAll();
        return darlingList;
    }
    @Override
    public List<Darling> GetAllGirlFriendParent() {
        List<Darling>darlings = darlingRepository.findDarlingByStatusOrStatus(1 , 2);
        return darlings;
    }

    @Override
    public List<Darling> getAllGfSulking(Integer status) {
        List<Darling> darlings = darlingRepository.findDarlingByStatus(status);
        return darlings;
    }

    @Override
    public Darling GetGirlFriendById(Long darlingId) {
        Optional<Darling> darlingOptional = darlingRepository.findById(darlingId);
        checkDarlingNotExits(darlingOptional);
        return darlingOptional.get();
    }

    @Override
    public String AddGirlFriend(DarlingDto darlingDto) {
     Darling darling = modelMapper.map(darlingDto , Darling.class);
     darlingRepository.save(darling);
     return "Create darling successful";
    }

    @Override
    public String EditInfoGfById(DarlingDto darlingDto, Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        checkDarlingNotExits(darling);
        modelMapper.map(darlingDto , Darling.class);
        darlingRepository.save(darling.get());
    return "Edit darling successful";
    }

    @Override
    public String ChangeStatus(Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        checkDarlingNotExits(darling);
        darling.get().setStatus(3);
        darlingRepository.save(darling.get());
    return "Change darling status successful";
    }

    @Override
    public List<Address> getListAddressGf(Long id) {
        Optional<Darling> darling = darlingRepository.findById(id);
        checkDarlingNotExits(darling);
    return darling.get().getAddress();
    }

    @Override
    public List<Darling> getSameGrProvince(Long darlingId , String province) {
      Optional<Darling> darlings = darlingRepository.findById(darlingId);
      checkDarlingNotExits(darlings);
       List<Address> addresses = darlings.get().getAddress();
       List<Darling> darling = new ArrayList<>();
       for (Address item : addresses){
           if(item.getName().equals(province))
               darling.add(item.getDarling());
       }
       return darling;
    }

    public void checkDarlingNotExits(Optional<Darling>darling){
        if(darling.isEmpty()){
            throw new NotFoundException(" DarlingId exists");
        }
    }
}
