package com.imooc.basic.learn_test;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @Resource
    private ItemDAO itemDAO;

    @Override
    public Item findById(String id) {

        return itemDAO.findById(id);
    }
}
