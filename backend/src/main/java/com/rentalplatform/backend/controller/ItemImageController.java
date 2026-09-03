package com.rentalplatform.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalplatform.backend.entity.ItemImage;
import com.rentalplatform.backend.service.ItemImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemImageController {

    private final ItemImageService service;

    @PostMapping("/{itemId}/images")
    public ItemImage addImage(@PathVariable Long itemId, @RequestParam String imageUrl, @RequestParam(defaultValue = "false") boolean primary) {

        return service.addImage(itemId, imageUrl, primary);
    }

    @GetMapping("/{itemId}/images")
    public List<ItemImage> getImages(
            @PathVariable Long itemId) {

        return service.getImages(itemId);
    }

    @DeleteMapping("/images/{imageId}")
    public void deleteImage(
            @PathVariable Long imageId) {

        service.deleteImage(imageId);
    }
}
