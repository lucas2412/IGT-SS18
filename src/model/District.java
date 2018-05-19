package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DISTRICT")
public class District implements Serializable {
    @Id
    private Integer D_ID;
    @Id
    private Integer D_W_ID;
    @Column
    private String D_NAME;
    @Column
    private String D_STRAßE;
    @Column
    private String D_STADT;
    @Column
    private Integer D_PLZ;
    @Column
    private Double D_STEUERSATZ;
    @Column
    private String D_YTD;


    public District() {
    }

    public Integer getD_ID() {
        return D_ID;
    }

    public void setD_ID(Integer d_ID) {
        D_ID = d_ID;
    }

    public Integer getD_W_ID() {
        return D_W_ID;
    }

    public void setD_W_ID(Integer d_W_ID) {
        D_W_ID = d_W_ID;
    }

    public String getD_NAME() {
        return D_NAME;
    }

    public void setD_NAME(String d_NAME) {
        D_NAME = d_NAME;
    }

    public String getD_STRAßE() {
        return D_STRAßE;
    }

    public void setD_STRAßE(String d_STRAßE) {
        D_STRAßE = d_STRAßE;
    }

    public String getD_STADT() {
        return D_STADT;
    }

    public void setD_STADT(String d_STADT) {
        D_STADT = d_STADT;
    }

    public Integer getD_PLZ() {
        return D_PLZ;
    }

    public void setD_PLZ(Integer d_PLZ) {
        D_PLZ = d_PLZ;
    }

    public Double getD_STEUERSATZ() {
        return D_STEUERSATZ;
    }

    public void setD_STEUERSATZ(Double d_STEUERSATZ) {
        D_STEUERSATZ = d_STEUERSATZ;
    }

    public String getD_YTD() {
        return D_YTD;
    }

    public void setD_YTD(String d_YTD) {
        D_YTD = d_YTD;
    }
}