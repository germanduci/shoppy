package com.ar.shoppy.repository;

import com.ar.shoppy.domain.Client;
import com.ar.shoppy.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface clientRepository extends JpaRepository <Client,String> {

    @Query("SELECT a FROM Client a WHERE a.name LIKE CONCAT('%',:name,'%')")
    public Optional<Client> findByClient(@Param("name") String name);
}
