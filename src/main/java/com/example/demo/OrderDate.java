package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "order_date")
public class OrderDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_id;

    @NotNull
    @Size(min=1, max=10)
    private String order_date;

    @OneToMany(mappedBy = "orderDate", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<OrderCombined> orderCombined;

    public long getOrder_id() {
        return order_id;
    }


    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public Set<OrderCombined> getOrderCombined() {
        return orderCombined;
    }

    public void setOrderCombined(Set<OrderCombined> orderCombined) {
        this.orderCombined = orderCombined;
    }
}
