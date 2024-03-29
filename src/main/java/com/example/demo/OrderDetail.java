package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.NumberFormat;
import java.util.Set;

@Entity(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_id;

    @NotNull
    @Min(1)
    @Max(1000)
    private int order_amount;

    @NotNull
    @Size(min = 1)
    private String order_description;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<OrderCombined> orderCombined;


    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public int getOrder_amount() {
        return this.order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public String getOrder_description() {
        return order_description;
    }

    public void setOrder_description(String order_description) {
        this.order_description = order_description;
    }

    public Set<OrderCombined> getOrderCombined() {
        return orderCombined;
    }

    public void setOrderCombined(Set<OrderCombined> orderCombined) {
        this.orderCombined = orderCombined;
    }
}
