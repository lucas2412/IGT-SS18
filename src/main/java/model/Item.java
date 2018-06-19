package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @Indexed
@Table(name = "ITEM")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer I_ID;
    @Column
    private String I_NAME;
    @Column
    private Double I_PRICE;

    public Item() {
    }


    @OneToMany(mappedBy = "stockItem")
    @JsonIgnore
    private List<Stock> stockList = new ArrayList<Stock>();

    @OneToMany(mappedBy = "orderlineItem")
    @JsonIgnore
    private List<OrderLine> orderlineList = new ArrayList<OrderLine>();

    public List<OrderLine> getOrderlineList() {
        return orderlineList;
    }

    public void setOrderlineList(List<OrderLine> orderlineList) {
        this.orderlineList = orderlineList;
    }

    public Integer getI_ID() {
        return I_ID;
    }

    public void setI_ID(Integer i_ID) {
        I_ID = i_ID;
    }

    public String getI_NAME() {
        return I_NAME;
    }

    public void setI_NAME(String i_NAME) {
        I_NAME = i_NAME;
    }

    public Double getI_PRICE() {
        return I_PRICE;
    }

    public void setI_PRICE(Double i_PRICE) {
        I_PRICE = i_PRICE;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }
}


