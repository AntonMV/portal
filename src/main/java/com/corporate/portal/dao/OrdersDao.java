package com.corporate.portal.dao;

import com.corporate.portal.model.Order;
import com.corporate.portal.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdersDao {
    private List<Order> orderList;

    {
        orderList = new ArrayList<>();
        orderList.add(new Order(1,"34534534", "Lipetsk", new User(1,"19115159", "Anton","anton@gamail.com")));
        orderList.add(new Order(2,"34516734", "Moscow", new User(2,"34516734", "Pavel","pavel@gamail.com")));
        orderList.add(new Order(3,"67812345", "Sochi", new User(2,"34516734", "Pavel","pavel@gamail.com")));
    }

    public Order show(int id) {
        return orderList.stream().filter(o -> o.getId() == id).findAny().orElse(null);
    }

    public List<Order> allList(){
        return orderList.stream().collect(Collectors.toList());
    }

    public void saveOrder(Order order){
        orderList.add(order);
    }

    public Order findOrder(int id){
        return orderList.stream()
                .filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public void putOrder(Order updateOrder, int id){
        Order orderToBeUpdated = show(id);
        orderToBeUpdated.setId(updateOrder.getId());
        orderToBeUpdated.setName(updateOrder.getName());
        orderToBeUpdated.setAddress(updateOrder.getAddress());
        orderToBeUpdated.setUser(updateOrder.getUser());

    }

    public void deleteOrder(int id){
        orderList.removeIf(o -> o.getId() == id);
    }
}
