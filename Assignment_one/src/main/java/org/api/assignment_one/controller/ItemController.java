package org.api.assignment_one.controller;

import org.api.assignment_one.model.Item;
import org.api.assignment_one.model.Promotion;
import org.api.assignment_one.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }

    @PostMapping("/{itemId}/promotions")
    public Item addPromotionToItem(@PathVariable String itemId, @RequestBody Promotion promotion) throws ChangeSetPersister.NotFoundException {
        return itemService.addPromotion(itemId, promotion);
    }

}