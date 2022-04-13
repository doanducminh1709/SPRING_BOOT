package com.example.chuabtvnb7.Services;

import com.example.chuabtvnb7.Dto.DarlingDTO;
import com.example.chuabtvnb7.Models.Address;
import com.example.chuabtvnb7.Models.Darling;
import org.springframework.stereotype.Service;
import java.util.Set;
@Service
public interface DarlingService {
   Set<Darling> getAllDarlings();
   Set<Darling> getAllDarlingByCurrent();
   Set<Darling> getAllDarlingAnnoy(Integer status);
   Darling getDarlingById(Long idDarling);
   Darling addNewDarling(DarlingDTO darlingDTO);
   Darling editDarlingById(Long idDarling ,  DarlingDTO darlingDTO);
   Darling deleteDarling(Long idDarling);
   Set<Address> getAllAddressByDarling(Long idDarling);
   Set<Darling> getAllDarlingSimilarProvince(Long idDarling , String province);
}
