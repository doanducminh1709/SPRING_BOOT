package com.example.btvnb7.Services;
import com.example.btvnb7.Dto.AddressDto;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
     String addAddressGf(Long id, AddressDto addressDto);
     String EditInfoAddressGf(Long darlingId , Long id , AddressDto addressDto);
     String DeleteAddressGf(Long addressId , Long darlingId);
}
