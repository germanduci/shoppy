package com.ar.shoppy.repositories;

import com.ar.shoppy.models.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface fileRepository extends JpaRepository<Archivo,String> {

    @Query("SELECT a FROM Archivo a WHERE a.archivoNombre LIKE %:name%")
    public Optional<Archivo> findByFile(@Param("name") String name);

}
