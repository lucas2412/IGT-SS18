package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NEW ORDER")
public class NewOrder implements Serializable {
    @Id
    private Integer NO_O_ID;
    @Id
    private Integer NO_D_ID;
    @Id
    private Integer NO_W_ID;

    public NewOrder() {
    }

    public Integer getNO_O_ID() {
        return NO_O_ID;
    }

    public void setNO_O_ID(Integer NO_O_ID) {
        this.NO_O_ID = NO_O_ID;
    }

    public Integer getNO_D_ID() {
        return NO_D_ID;
    }

    public void setNO_D_ID(Integer NO_D_ID) {
        this.NO_D_ID = NO_D_ID;
    }

    public Integer getNO_W_ID() {
        return NO_W_ID;
    }

    public void setNO_W_ID(Integer NO_W_ID) {
        this.NO_W_ID = NO_W_ID;
    }
}
