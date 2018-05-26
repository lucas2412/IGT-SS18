package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DISTRICT")
public class District implements Serializable {
    @Id
    private Integer D_ID;
    @Column
    private Integer D_W_ID;
    @Column
    private String D_NAME;
    @Column
    private String D_STRAßE;
    @Column
    private String D_STADT;
    @Column
    private String D_PLZ;


    public District() {
    }


    @ManyToOne
    @JoinColumn(name = "D_W_ID", insertable=false, updatable = false)
    private Warehouse DistrictWarehouse;


    @OneToMany(mappedBy = "CustomerDistrict")
    private List<Customer> customerList = new ArrayList<Customer>();


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

    public String getD_PLZ() {
        return D_PLZ;
    }

    public void setD_PLZ(String d_PLZ) {
        D_PLZ = d_PLZ;
    }

    public Warehouse getDistrictWarehouse() {
        return DistrictWarehouse;
    }

    public void setDistrictWarehouse(Warehouse districtWarehouse) {
        DistrictWarehouse = districtWarehouse;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}