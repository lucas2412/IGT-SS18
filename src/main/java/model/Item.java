package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable {
    @Id
    private Integer I_ID;
    @Column
    private Integer I_IM_ID;
    @Column
    private String I_NAME;
    @Column
    private Double I_PRICE;

    public Item() {
    }


    @OneToMany(mappedBy = "stockItem")
    private List<Stock> stockList = new ArrayList<Stock>();


    public Integer getI_ID() {
        return I_ID;
    }

    public void setI_ID(Integer i_ID) {
        I_ID = i_ID;
    }

    public Integer getI_IM_ID() {
        return I_IM_ID;
    }

    public void setI_IM_ID(Integer i_IM_ID) {
        I_IM_ID = i_IM_ID;
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


