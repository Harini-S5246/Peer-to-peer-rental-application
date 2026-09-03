package com.rentalplatform.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rentalplatform.backend.entity.Item;
import com.rentalplatform.backend.entity.ItemImage;
import com.rentalplatform.backend.repository.ItemImageRepository;
import com.rentalplatform.backend.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemImageService {

    private final ItemImageRepository repository;
    private final ItemRepository itemRepository;

    public ItemImage addImage(Long itemId, String imageUrl, boolean primary) {

        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        ItemImage image = new ItemImage();

        image.setItem(item);
        image.setImageUrl(imageUrl);
        image.setIsPrimary(primary);

        return repository.save(image);
    }

    public List<ItemImage> getImages(Long itemId) {
        return repository.findByItemItemId(itemId);
    }

    public void deleteImage(Long imageId) {
        repository.deleteById(imageId);
    }
}