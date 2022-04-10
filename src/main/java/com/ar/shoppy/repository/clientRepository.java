package com.ar.shoppy.repository;

import com.ar.shoppy.domain.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface clientRepository extends JpaRepository <client,String> {

    @Query("SELECT a FROM Client a WHERE a.name LIKE CONCAT('%',:name,'%')")
    public Optional<client> findByClient(@Param("name") String name);
}
