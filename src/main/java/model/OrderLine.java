package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORDER LINE")
public class OrderLine implements Serializable {
    @Id
    private Integer OL_O_ID;
    @Id
    private Integer OL_D_ID;
    @Id
    private Integer OL_W_ID;
    @Id
    private Integer OL_NUMBER;
    @Column
    private Integer OL_I_ID;
    @Column
    private Integer OL_SUPPLY_W_ID;
    @Column
    private Date OL_DELIVERY_D;
    @Column
    private Integer OL_QUANTITY;
    @Column
    private Integer OL_AMOUNT;

    public OrderLine() {
    }

    public Integer getOL_O_ID() {
        return OL_O_ID;
    }

    public void setOL_O_ID(Integer OL_O_ID) {
        this.OL_O_ID = OL_O_ID;
    }

    public Integer getOL_D_ID() {
        return OL_D_ID;
    }

    public void setOL_D_ID(Integer OL_D_ID) {
        this.OL_D_ID = OL_D_ID;
    }

    public Integer getOL_W_ID() {
        return OL_W_ID;
    }

    public void setOL_W_ID(Integer OL_W_ID) {
        this.OL_W_ID = OL_W_ID;
    }

    public Integer getOL_NUMBER() {
        return OL_NUMBER;
    }

    public void setOL_NUMBER(Integer OL_NUMBER) {
        this.OL_NUMBER = OL_NUMBER;
    }

    public Integer getOL_I_ID() {
        return OL_I_ID;
    }

    public void setOL_I_ID(Integer OL_I_ID) {
        this.OL_I_ID = OL_I_ID;
    }

    public Integer getOL_SUPPLY_W_ID() {
        return OL_SUPPLY_W_ID;
    }

    public void setOL_SUPPLY_W_ID(Integer OL_SUPPLY_W_ID) {
        this.OL_SUPPLY_W_ID = OL_SUPPLY_W_ID;
    }

    public Date getOL_DELIVERY_D() {
        return OL_DELIVERY_D;
    }

    public void setOL_DELIVERY_D(Date OL_DELIVERY_D) {
        this.OL_DELIVERY_D = OL_DELIVERY_D;
    }

    public Integer getOL_QUANTITY() {
        return OL_QUANTITY;
    }

    public void setOL_QUANTITY(Integer OL_QUANTITY) {
        this.OL_QUANTITY = OL_QUANTITY;
    }

    public Integer getOL_AMOUNT() {
        return OL_AMOUNT;
    }

    public void setOL_AMOUNT(Integer OL_AMOUNT) {
        this.OL_AMOUNT = OL_AMOUNT;
    }
}
