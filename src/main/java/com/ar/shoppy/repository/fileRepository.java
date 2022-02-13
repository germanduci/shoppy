package com.ar.shoppy.repository;

import com.ar.shoppy.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fileRepository extends JpaRepository<File,String> {
}
