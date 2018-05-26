package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORDER LINE")
public class OrderLine implements Serializable {
    @Id
    private Integer OL_NUMBER;
    @Column
    private Integer OL_O_ID;
    @Column
    private Integer OL_S_ID;
    @Column
    private Integer OL_S_I_ID;
    @Column
    private Date OL_DELIVERY_D;
    @Column
    private Integer OL_QUANTITY;
    @Column
    private Integer OL_AMOUNT;

    public OrderLine() {
    }

    @ManyToOne
    @JoinColumn(name = "OL_O_ID", insertable=false, updatable = false)
    private Order OL_Order;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "OL_S_ID", insertable=false, updatable = false),
            @JoinColumn(name = "OL_S_I_ID", insertable=false, updatable = false)
    })
    private Stock OL_Stock;

    public Integer getOL_NUMBER() {
        return OL_NUMBER;
    }

    public void setOL_NUMBER(Integer OL_NUMBER) {
        this.OL_NUMBER = OL_NUMBER;
    }

    public Integer getOL_O_ID() {
        return OL_O_ID;
    }

    public void setOL_O_ID(Integer OL_O_ID) {
        this.OL_O_ID = OL_O_ID;
    }

    public Integer getOL_S_ID() {
        return OL_S_ID;
    }

    public void setOL_S_ID(Integer OL_S_ID) {
        this.OL_S_ID = OL_S_ID;
    }

    public Integer getOL_S_I_ID() {
        return OL_S_I_ID;
    }

    public void setOL_S_I_ID(Integer OL_S_I_ID) {
        this.OL_S_I_ID = OL_S_I_ID;
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

    public Order getOL_Order() {
        return OL_Order;
    }

    public void setOL_Order(Order OL_Order) {
        this.OL_Order = OL_Order;
    }

    public Stock getOL_Stock() {
        return OL_Stock;
    }

    public void setOL_Stock(Stock OL_Stock) {
        this.OL_Stock = OL_Stock;
    }
}
