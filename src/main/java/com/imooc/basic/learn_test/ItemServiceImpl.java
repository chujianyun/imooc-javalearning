package com.imooc.basic.learn_test;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemRepository itemRepository;

    @Override
    public String getItemNameUpperCase(String itemId) {

        Item item = itemRepository.findById(itemId);

        if (item == null) {
            return null;
        }
        return item.getName().toUpperCase();
    }
}
