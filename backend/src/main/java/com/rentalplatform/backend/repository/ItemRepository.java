package com.rentalplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalplatform.backend.entity.Item;
import java.util.List;
import java.util.UUID;


public interface ItemRepository extends JpaRepository<Item, Long>{
    List<Item> findByAvailabilityTrue();
    List<Item> findByOwnerId(UUID ownerId);
}
