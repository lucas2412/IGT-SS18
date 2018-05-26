package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HISTORY")
public class History implements Serializable {
    @Id
    private Integer H_ID;
    @Column
    private Date H_DATE;
    @Column
    private Double H_AMOUNT;

    public History() {
    }

    @OneToOne(mappedBy = "CustomerHistory")
    private Customer customer;

    @OneToMany(mappedBy = "OrderHistory")
    private List<Order> orderList = new ArrayList<Order>();


    public Integer getH_ID() {
        return H_ID;
    }

    public void setH_ID(Integer h_ID) {
        H_ID = h_ID;
    }

    public Date getH_DATE() {
        return H_DATE;
    }

    public void setH_DATE(Date h_DATE) {
        H_DATE = h_DATE;
    }

    public Double getH_AMOUNT() {
        return H_AMOUNT;
    }

    public void setH_AMOUNT(Double h_AMOUNT) {
        H_AMOUNT = h_AMOUNT;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
