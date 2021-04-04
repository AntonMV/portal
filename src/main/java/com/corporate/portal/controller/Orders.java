package com.corporate.portal.controller;

import com.corporate.portal.dao.OrdersDao;
import com.corporate.portal.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Orders {

    private final OrdersDao ordersDao;

    @Autowired
    public Orders(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order newOrders(@RequestBody Order order) {
        ordersDao.saveOrder(order);
        return order;
    }

    @GetMapping("/orders/{id}")
    public Order getOrders(@PathVariable("id") int id) {
        return ordersDao.findOrder(id);
    }


    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> putOrders(@RequestBody Order order, @PathVariable("id") int id) {
        ordersDao.putOrder(order, id);
        return ordersDao.allList();
    }

    @DeleteMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> deleteOrders(@PathVariable("id") int id) {
        ordersDao.deleteOrder(id);
        return ordersDao.allList();
    }
}
