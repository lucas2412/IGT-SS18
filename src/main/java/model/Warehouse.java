package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "WAREHOUSE")
public class Warehouse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer W_ID;
    @Column
    private String W_NAME;
    @Column
    private String W_STRASSE;
    @Column
    private String W_STADT;
    @Column
    private String W_PLZ;

    public Warehouse() {
    }


    @OneToMany(mappedBy = "DistrictWarehouse")
    @JsonIgnore
    private List<District> districtList = new ArrayList<District>();


    @OneToMany(mappedBy = "StockWarehouse")
    @JsonIgnore
    private List<Stock> stockList = new ArrayList<Stock>();


    public Integer getW_ID() {
        return W_ID;
    }

    public void setW_ID(Integer w_ID) {
        W_ID = w_ID;
    }

    public String getW_NAME() {
        return W_NAME;
    }

    public void setW_NAME(String w_NAME) {
        W_NAME = w_NAME;
    }

    public String getW_STRASSE() {
        return W_STRASSE;
    }

    public void setW_STRASSE(String w_STRASSE) {
        W_STRASSE = w_STRASSE;
    }

    public String getW_STADT() {
        return W_STADT;
    }

    public void setW_STADT(String w_STADT) {
        W_STADT = w_STADT;
    }

    public String getW_PLZ() {
        return W_PLZ;
    }

    public void setW_PLZ(String w_PLZ) {
        W_PLZ = w_PLZ;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }
}