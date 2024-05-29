package com.pede.ai.infra.outbounds;

import com.pede.ai.infra.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
}