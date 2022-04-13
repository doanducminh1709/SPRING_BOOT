package com.example.ontapbuoi5.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Int> {
    //sử dụng cách 1 đặt theo biến để query
    @Query("select n from User n order by n.username desc ")
    List<User> findAllByOOrderByUsername();
    //u dung nativeQuery
    //luu y cach dat sao cho chuaarn
    @Query(value = "select e.*from User e order by  e.username asc ", nativeQuery = true);
    List<User> findAllByUsernameAsc(String username);

    //su dung Param
    @Query("SELECT e FROM Customer e WHERE e.name = :name AND e.address=:address")
    List<Customer> findByNameAndAddress(@Param("name") String name, @Param("address") String address);
    @Query("SELECT e FROM Customer e WHERE e.name like ?1")
    List<Customer> findByNameLike(String name);

}


