package com.ar.shoppy.repositories;

import com.ar.shoppy.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface clientRepository extends JpaRepository <Cliente,String> {
    @Query("SELECT a FROM Cliente a WHERE a.clienteNombre LIKE %:name%")
    public Optional<Cliente> findByClientName(@Param("name") String name);
}
