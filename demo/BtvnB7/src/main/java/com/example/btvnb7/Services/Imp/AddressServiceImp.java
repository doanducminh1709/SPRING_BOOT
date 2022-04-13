package com.example.btvnb7.Services.Imp;

import com.example.btvnb7.Dto.AddressDto;
import com.example.btvnb7.Exception.NotFoundException;
import com.example.btvnb7.Models.Address;
import com.example.btvnb7.Models.Darling;
import com.example.btvnb7.Repository.AddressRepository;
import com.example.btvnb7.Repository.DarlingRepository;
import com.example.btvnb7.Services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AddressServiceImp implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DarlingRepository darlingRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String addAddressGf(Long darlingId , AddressDto addressDto) {
      Optional<Darling> darling = darlingRepository.findById(darlingId);
      checkDarlingExists(darling);
      Address address = modelMapper.map(addressDto , Address.class);
      address.setDarling(darling.get());
      addressRepository.save(address);
    return "Create successful";
    }

    @Override
    public String EditInfoAddressGf(Long darlingId , Long id, AddressDto addressDto) {
        Optional<Darling> darling = darlingRepository.findById(darlingId);
        checkDarlingExists(darling);
        Optional<Address> address = addressRepository.findById(id);
        checkAddressExists(address);
        modelMapper.map(addressDto , address.get());
        addressRepository.save(address.get());
    return "update successful";
    }

    @Override
    public String DeleteAddressGf(Long addressId , Long darlingId) {
      Optional<Address> address = addressRepository.findById(addressId);
      checkAddressExists(address);
      Optional<Darling> darling = darlingRepository.findById(darlingId);
      checkDarlingExists(darling);
      addressRepository.delete(address.get());
    return "Delete successful";
    }

    public void checkDarlingExists(Optional<Darling> darling){
        if(darling.isEmpty()){
          throw new NotFoundException(" Not found darling id");
        }
    }
    public void checkAddressExists(Optional<Address> address){
        if(address.isEmpty()){
        throw new NotFoundException("Not found address id");
        }
    }
}
