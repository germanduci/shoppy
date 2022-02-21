package com.ar.shoppy.repository;

import com.ar.shoppy.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface orderRepository extends JpaRepository<Order,String> {

    @Query("SELECT a FROM Order a WHERE a.client.name LIKE %:name%")
    public Optional<Order> findByClient(@Param("name") String name);

    @Query("SELECT a FROM Order a WHERE a.status=:status")
    public List<Order> findByStatus(@Param("status")String status);

}
