package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ORDER")
public class Order implements Serializable {
    @Id
    private Integer O_ID;
    @Id
    private Integer O_D_ID;
    @Id
    private Integer O_W_ID;
    @Column
    private Integer O_C_ID;
    @Column
    private Date O_EINGANSDATUM;
    @Column
    private Integer O_AUSLIEFERER_ID;
    @Column
    private Integer O_OL_CNT;
    @Column
    private Integer O_ALL_LOCAL;

    public Order() {
    }

    public Integer getO_ID() {
        return O_ID;
    }

    public void setO_ID(Integer o_ID) {
        O_ID = o_ID;
    }

    public Integer getO_D_ID() {
        return O_D_ID;
    }

    public void setO_D_ID(Integer o_D_ID) {
        O_D_ID = o_D_ID;
    }

    public Integer getO_W_ID() {
        return O_W_ID;
    }

    public void setO_W_ID(Integer o_W_ID) {
        O_W_ID = o_W_ID;
    }

    public Integer getO_C_ID() {
        return O_C_ID;
    }

    public void setO_C_ID(Integer o_C_ID) {
        O_C_ID = o_C_ID;
    }

    public Date getO_EINGANSDATUM() {
        return O_EINGANSDATUM;
    }

    public void setO_EINGANSDATUM(Date o_EINGANSDATUM) {
        O_EINGANSDATUM = o_EINGANSDATUM;
    }

    public Integer getO_AUSLIEFERER_ID() {
        return O_AUSLIEFERER_ID;
    }

    public void setO_AUSLIEFERER_ID(Integer o_AUSLIEFERER_ID) {
        O_AUSLIEFERER_ID = o_AUSLIEFERER_ID;
    }

    public Integer getO_OL_CNT() {
        return O_OL_CNT;
    }

    public void setO_OL_CNT(Integer o_OL_CNT) {
        O_OL_CNT = o_OL_CNT;
    }

    public Integer getO_ALL_LOCAL() {
        return O_ALL_LOCAL;
    }

    public void setO_ALL_LOCAL(Integer o_ALL_LOCAL) {
        O_ALL_LOCAL = o_ALL_LOCAL;
    }
}
