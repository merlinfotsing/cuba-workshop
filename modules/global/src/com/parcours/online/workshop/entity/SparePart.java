package com.parcours.online.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s|title")
@Table(name = "WORKSHOP_SPARE_PART")
@Entity(name = "workshop$SparePart")
public class SparePart extends StandardEntity {
    private static final long serialVersionUID = -4568152525436409619L;

    @Column(name = "TITLE", nullable = false, unique = true)
    protected String title;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    @JoinTable(name = "WORKSHOP_ORDER_SPARE_PART_LINK",
        joinColumns = @JoinColumn(name = "SPARE_PART_ID"),
        inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    @ManyToMany
    protected Set<Order> orders;

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return orders;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }


}