package com.pede.ai.infra.outbounds;

import com.pede.ai.infra.entities.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemOrderRepository extends JpaRepository<ItemOrderEntity, Long> {
}