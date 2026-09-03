package com.rentalplatform.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalplatform.backend.entity.ItemImage;

public interface ItemImageRepository extends JpaRepository<ItemImage, Long> {

    List<ItemImage> findByItemItemId(Long itemId);
}
