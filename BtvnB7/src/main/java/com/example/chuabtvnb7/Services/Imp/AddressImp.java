package com.example.chuabtvnb7.Services.Imp;
import com.example.chuabtvnb7.Dto.AddressDTO;
import com.example.chuabtvnb7.Exception.NotFoundException;
import com.example.chuabtvnb7.Models.Address;
import com.example.chuabtvnb7.Models.Darling;
import com.example.chuabtvnb7.Repository.AddressRepository;
import com.example.chuabtvnb7.Repository.DarlingRepository;
import com.example.chuabtvnb7.Services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Component
public class AddressImp implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DarlingRepository darlingRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Address addInformation(Long idDarling, AddressDTO addressDTO) {
       Optional<Darling> darling = darlingRepository.findById(idDarling);
       if(darling.isEmpty()){
           throw new NotFoundException(" Id darling not found");
       }
       Address address = modelMapper.map(addressDTO , Address.class);
       return addressRepository.save(address);
    }

    @Override
    public Address editInformation(Long idAddress, Long idDarling, AddressDTO addressDTO) {
       Optional<Address> address = addressRepository.findById(idAddress);
       if(address.isEmpty()){
           throw new NotFoundException(" Not found ");
       }
       Optional<Darling> darling = darlingRepository.findById(idDarling);
        if(darling.isEmpty()){
            throw new NotFoundException(" Not found ");
        }
        Address address1 = new Address();
        address1.setName(addressDTO.getName());
        address1.setCode(addressDTO.getCode());
        address1.setDarling(darling.get());
      return addressRepository.save(address1);
    }

    @Override
    public Darling deleteAddress(Long idAddress, Long idDarling) {

    Optional<Darling> darling = darlingRepository.findById(idDarling);
    if(darling.isEmpty()){
        throw new NotFoundException("Not found darling id");
    }
      darling.get().setStatus(3);
      return darlingRepository.save(darling.get());
    }

}
