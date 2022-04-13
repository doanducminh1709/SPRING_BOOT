package com.example.chuabtvnb7.Services.Imp;

import com.example.chuabtvnb7.Dto.DarlingDTO;
import com.example.chuabtvnb7.Exception.NotFoundException;
import com.example.chuabtvnb7.Models.Address;
import com.example.chuabtvnb7.Models.Darling;
import com.example.chuabtvnb7.Repository.AddressRepository;
import com.example.chuabtvnb7.Repository.DarlingRepository;
import com.example.chuabtvnb7.Services.DarlingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Component
public class DarlingImp implements DarlingService {
    @Autowired
    DarlingRepository darlingRepository;

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Set<Darling> getAllDarlings() {
        Set<Darling> darlings = new HashSet<>(darlingRepository.findAll());
        return darlings;
    }

    @Override
    public Set<Darling> getAllDarlingByCurrent() {
        return new HashSet<>(darlingRepository.findAllByStatusNot(3));
    }

    @Override
    public Set<Darling> getAllDarlingAnnoy(Integer status) {
        Set<Darling> darlings = new HashSet<>();
        darlings.add(darlingRepository.findDarlingByStatus(status));
        return darlings;
    }

    @Override
    public Darling getDarlingById(Long idDarling) {
        Darling darling = darlingRepository.findAllById(idDarling);
        return darling;
    }

    @Override
    public Darling addNewDarling(DarlingDTO darlingDTO) {
        Darling newDarling = modelMapper.map(darlingDTO , Darling.class);
        darlingRepository.save(newDarling);
        return newDarling;
    }

    @Override
    public Darling editDarlingById(Long idDarling, DarlingDTO darlingDTO) {
        Optional<Darling> darling = darlingRepository.findById(idDarling);
        if (darling.isEmpty()) {
            throw new NotFoundException("No found value");
        }
        Darling darlings = modelMapper.map(darlingDTO , Darling.class);
        return darlingRepository.save(darlings);
    }

    @Override
    public Darling deleteDarling(Long idDarling) {
        Optional<Darling> darling = darlingRepository.findById(idDarling);
        if (darling.isEmpty()) {
            throw new NotFoundException(" Not found ");
        }
        darlingRepository.delete(darling.get());
        return darling.get();
    }

    @Override
    public Set<Address> getAllAddressByDarling(Long idDarling) {
        Optional<Darling> darling = darlingRepository.findById(idDarling);
        if (darling.isEmpty()) {
            throw new NotFoundException(" Not found darling by id");
        }
        Set<Address> addresses = addressRepository.findAllByDarling(darling.get());
        if (addresses.isEmpty()) {
            throw new NotFoundException(" Not found address");
        }
        return addresses;
    }

    @Override
    public Set<Darling> getAllDarlingSimilarProvince(Long idDarling, String province) {
        Optional<Address> address = Optional.ofNullable(addressRepository.findAddressByName(province)); //
        Optional<Darling> darling = darlingRepository.findById(idDarling);
        if (darling.isEmpty()) {
            throw new NotFoundException(" Not found ");
        }
        Set<Darling> darlings = (Set<Darling>) darlingRepository.findDarlingByAddress(address.get());
        return darlings;
    }
}
