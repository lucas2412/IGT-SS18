package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORDERLINE")
public class OrderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer OL_NUMBER;
    @Column
    private Integer OL_O_ID;
    @Column
    private Integer OL_I_ID;
    @Column
    private Date OL_DELIVERY_D;
    @Column
    private Integer OL_AMOUNT;

    public OrderLine() {
    }

    @ManyToOne
    @JoinColumn(name = "OL_I_ID", insertable=false, updatable = false)
    private Item orderlineItem;


    @ManyToOne
    @JoinColumn(name = "OL_O_ID", insertable=false, updatable = false)
    private Order2 OL_Order;




    public Item getOrderlineItem() {
        return orderlineItem;
    }

    public void setOrderlineItem(Item orderlineItem) {
        this.orderlineItem = orderlineItem;
    }

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




    public Integer getOL_I_ID() {
        return OL_I_ID;
    }

    public void setOL_I_ID(Integer OL_I_ID) {
        this.OL_I_ID = OL_I_ID;
    }

    public Date getOL_DELIVERY_D() {
        return OL_DELIVERY_D;
    }

    public void setOL_DELIVERY_D(Date OL_DELIVERY_D) {
        this.OL_DELIVERY_D = OL_DELIVERY_D;
    }

    public Integer getOL_AMOUNT() {
        return OL_AMOUNT;
    }

    public void setOL_AMOUNT(Integer OL_AMOUNT) {
        this.OL_AMOUNT = OL_AMOUNT;
    }

    public Order2 getOL_Order() {
        return OL_Order;
    }

    public void setOL_Order(Order2 OL_Order) {
        this.OL_Order = OL_Order;
    }


}
