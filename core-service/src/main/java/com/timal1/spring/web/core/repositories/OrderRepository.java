package com.timal1.spring.web.core.repositories;

import com.timal1.spring.web.core.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.username = ?1")
    List<Order> findAllByUsername(String username);


}
