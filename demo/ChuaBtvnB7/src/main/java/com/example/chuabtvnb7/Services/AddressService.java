package com.example.chuabtvnb7.Services;
import com.example.chuabtvnb7.Dto.AddressDTO;
import com.example.chuabtvnb7.Models.Address;
import com.example.chuabtvnb7.Models.Darling;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address addInformation(Long id , AddressDTO addressDTO);
    Address editInformation(Long idAddress , Long idDarling ,AddressDTO addressDTO);
    Darling deleteAddress(Long idAddress , Long idDarling);

}
