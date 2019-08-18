package com.example.demo;

import javax.persistence.*;

@Entity(name = "order_combined")
public class OrderCombined {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_id;

    private String order_date;

    private int order_amount;

    private String order_description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderDate_Id")
    private OrderDate orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderDetail_Id")
    private OrderDetail orderDetail;

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

    public OrderDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OrderDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
