package com.ar.shoppy.repositories;

import com.ar.shoppy.models.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface orderRepository extends JpaRepository<Orden,String> {

    @Query("SELECT a FROM Orden a WHERE a.orderEstado=:status")
    public List<Orden> findByStatus(@Param("status")String status);

}
