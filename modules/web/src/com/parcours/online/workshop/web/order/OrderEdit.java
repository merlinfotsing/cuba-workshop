package com.parcours.online.workshop.web.order;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.parcours.online.workshop.entity.Order;
import com.parcours.online.workshop.entity.OrderStatus;
import com.parcours.online.workshop.service.OrderService;

import javax.inject.Inject;

public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private OrderService orderService;

    @Override
    public void initNewItem(Order item){
        super.initNewItem(item);
        item.setStatus(OrderStatus.NEW);
    }

    @Override
    public boolean preCommit() {
        Order order = super.getItem();
        order.setAmount(orderService.calculateAmount(order));
        return super.preCommit();
    }
}