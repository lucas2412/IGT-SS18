package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    private Integer C_ID;
    @Id
    private Integer C_D_ID;
    @Id
    private Integer C_W_ID;
    @Column
    private String C_STRAßE;
    @Column
    private String C_STADT;
    @Column
    private String C_PLZ;
    @Column
    private String C_TELEFONNUMMER;
    @Column
    private Date C_KUNDESEIT;
    @Column
    private String C_KREDITSCORE;
    @Column
    private Double C_KREDITLIMIT;
    @Column
    private Double C_RABATT;
    @Column
    private Double C_KONTOSTAND;


    public Customer() {
    }

    public Integer getC_ID() {
        return C_ID;
    }

    public void setC_ID(Integer c_ID) {
        C_ID = c_ID;
    }

    public Integer getC_D_ID() {
        return C_D_ID;
    }

    public void setC_D_ID(Integer c_D_ID) {
        C_D_ID = c_D_ID;
    }

    public Integer getC_W_ID() {
        return C_W_ID;
    }

    public void setC_W_ID(Integer c_W_ID) {
        C_W_ID = c_W_ID;
    }

    public String getC_STRAßE() {
        return C_STRAßE;
    }

    public void setC_STRAßE(String c_STRAßE) {
        C_STRAßE = c_STRAßE;
    }

    public String getC_STADT() {
        return C_STADT;
    }

    public void setC_STADT(String c_STADT) {
        C_STADT = c_STADT;
    }

    public String getC_PLZ() {
        return C_PLZ;
    }

    public void setC_PLZ(String c_PLZ) {
        C_PLZ = c_PLZ;
    }

    public String getC_TELEFONNUMMER() {
        return C_TELEFONNUMMER;
    }

    public void setC_TELEFONNUMMER(String c_TELEFONNUMMER) {
        C_TELEFONNUMMER = c_TELEFONNUMMER;
    }

    public Date getC_KUNDESEIT() {
        return C_KUNDESEIT;
    }

    public void setC_KUNDESEIT(Date c_KUNDESEIT) {
        C_KUNDESEIT = c_KUNDESEIT;
    }

    public String getC_KREDITSCORE() {
        return C_KREDITSCORE;
    }

    public void setC_KREDITSCORE(String c_KREDITSCORE) {
        C_KREDITSCORE = c_KREDITSCORE;
    }

    public Double getC_KREDITLIMIT() {
        return C_KREDITLIMIT;
    }

    public void setC_KREDITLIMIT(Double c_KREDITLIMIT) {
        C_KREDITLIMIT = c_KREDITLIMIT;
    }

    public Double getC_RABATT() {
        return C_RABATT;
    }

    public void setC_RABATT(Double c_RABATT) {
        C_RABATT = c_RABATT;
    }

    public Double getC_KONTOSTAND() {
        return C_KONTOSTAND;
    }

    public void setC_KONTOSTAND(Double c_KONTOSTAND) {
        C_KONTOSTAND = c_KONTOSTAND;
    }
}
