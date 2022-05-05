package com.ar.shoppy.repositories;

import com.ar.shoppy.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface fileRepository extends JpaRepository<File,String> {

    @Query("SELECT a FROM File a WHERE a.name LIKE CONCAT('%',:name,'%')")
    public Optional<File> findByFile(@Param("name") String name);

}
