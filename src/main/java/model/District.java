package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity @Indexed
@Table(name = "DISTRICT")
public class District implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer D_ID;
    @Column
    private Integer D_W_ID;
    @Column
    private String D_NAME;
    @Column
    private String D_STRASSE;
    @Column
    private String D_STADT;
    @Column
    private String D_PLZ;


    public District() {
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "D_W_ID", insertable=false, updatable = false)
    @JsonBackReference
    private Warehouse DistrictWarehouse;


    @OneToMany(mappedBy = "CustomerDistrict")
    @JsonIgnore
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

    public String getD_STRASSE() {
        return D_STRASSE;
    }

    public void setD_STRASSE(String d_STRASSE) {
        D_STRASSE = d_STRASSE;
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