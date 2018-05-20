package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

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
}