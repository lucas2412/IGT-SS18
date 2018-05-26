package model;

import org.neo4j.cypher.internal.frontend.v2_3.ast.Or;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NEW ORDER")
public class NewOrder implements Serializable {
    @Id
    private Integer NO_ID;
    @Column
    private Integer NO_O_ID;


    public NewOrder() {
    }


    @OneToOne
    @JoinColumn(name = "NO_O_ID", insertable=false, updatable = false)
    private Order NewOrder;


    public Integer getNO_ID() {
        return NO_ID;
    }

    public void setNO_ID(Integer NO_ID) {
        this.NO_ID = NO_ID;
    }

    public Integer getNO_O_ID() {
        return NO_O_ID;
    }

    public void setNO_O_ID(Integer NO_O_ID) {
        this.NO_O_ID = NO_O_ID;
    }

    public Order getNewOrder() {
        return NewOrder;
    }

    public void setNewOrder(Order newOrder) {
        NewOrder = newOrder;
    }
}
