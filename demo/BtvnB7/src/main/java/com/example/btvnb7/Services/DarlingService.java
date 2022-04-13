package com.example.btvnb7.Services;
import com.example.btvnb7.Dto.DarlingDto;
import com.example.btvnb7.Models.Address;
import com.example.btvnb7.Models.Darling;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface DarlingService {
     List<Darling> GetAllGirlFriend();
     List<Darling> GetAllGirlFriendParent();
     List<Darling> getAllGfSulking(Integer status);
     Darling GetGirlFriendById(Long darlingId);
     String AddGirlFriend(DarlingDto darlingDto);
     String EditInfoGfById(DarlingDto darlingDto , Long id);
     String ChangeStatus(Long id);
     List<Address> getListAddressGf(Long id);
     List<Darling> getSameGrProvince(Long darlingId , String province);
}
