package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Indexed;
import org.neo4j.cypher.internal.frontend.v2_3.ast.Or;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Indexed
@Table(name = "NEWORDER")
public class NewOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer NO_ID;
    @Column
    private Integer NO_O_ID;


    public NewOrder() {
    }


   // @OneToOne(cascade = {CascadeType.ALL})
    @OneToOne
    @JoinColumn(name = "NO_O_ID", insertable=false, updatable = false)
    @JsonIgnore
    private Order2 NewOrder;


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

    public Order2 getNewOrder() {
        return NewOrder;
    }

    public void setNewOrder(Order2 newOrder) {
        NewOrder = newOrder;
    }
}
