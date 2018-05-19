package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HISTORY")
public class History implements Serializable {
    @Id
    private Integer H_ID;
    @Column
    private Integer H_C_ID;
    @Column
    private Integer H_C_D_ID;
    @Column
    private Integer H_C_W_ID;
    @Column
    private Integer H_D_ID;
    @Column
    private Integer H_W_ID;
    @Column
    private Date H_DATE;
    @Column
    private Double H_AMOUNT;

    public History() {
    }

    public Integer getH_ID() {
        return H_ID;
    }

    public void setH_ID(Integer h_ID) {
        H_ID = h_ID;
    }

    public Integer getH_C_ID() {
        return H_C_ID;
    }

    public void setH_C_ID(Integer h_C_ID) {
        H_C_ID = h_C_ID;
    }

    public Integer getH_C_D_ID() {
        return H_C_D_ID;
    }

    public void setH_C_D_ID(Integer h_C_D_ID) {
        H_C_D_ID = h_C_D_ID;
    }

    public Integer getH_C_W_ID() {
        return H_C_W_ID;
    }

    public void setH_C_W_ID(Integer h_C_W_ID) {
        H_C_W_ID = h_C_W_ID;
    }

    public Integer getH_D_ID() {
        return H_D_ID;
    }

    public void setH_D_ID(Integer h_D_ID) {
        H_D_ID = h_D_ID;
    }

    public Integer getH_W_ID() {
        return H_W_ID;
    }

    public void setH_W_ID(Integer h_W_ID) {
        H_W_ID = h_W_ID;
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
}
