package com.parcours.online.workshop.web.order;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.Datasource;
import com.parcours.online.workshop.entity.Order;
import com.parcours.online.workshop.entity.OrderStatus;

public class OrderBrowse extends AbstractLookup {

    private static final String ORDERS_DS = "ordersDs";

    public void onBtnNewStatusClick(Component component) {
        Datasource orderDatasource = super.getDsContext().get(ORDERS_DS);
        Order selectedItem =  orderDatasource != null ? (Order)orderDatasource.getItem() : null;
        if (selectedItem != null) {
            selectedItem.setStatus(OrderStatus.NEW);
            orderDatasource.commit();
        }
    }
}