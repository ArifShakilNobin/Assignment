package org.api.assignment_one.service;

import org.api.assignment_one.model.Item;
import org.api.assignment_one.model.Promotion;
import org.api.assignment_one.repository.ItemRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(String id) {
        return itemRepository.findById((new ObjectId(id)));
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(String id, Item newItem) {
        newItem.setId(new ObjectId(id));
        return itemRepository.save(newItem);
    }

    public void deleteItem(String id) {
        itemRepository.deleteById((new ObjectId(id)));
    }

    public Item addPromotion(String itemId, Promotion promotion) throws ChangeSetPersister.NotFoundException {
        Item item = getItemById(itemId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        List<Promotion> promotions = item.getPromotions();
        promotions.add(promotion);
        item.setPromotions(promotions);
        return updateItem(itemId, item);
    }

}