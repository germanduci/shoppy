package com.ar.shoppy.repositories;

import com.ar.shoppy.models.Client;
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
