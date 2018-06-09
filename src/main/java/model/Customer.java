package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer C_ID;
    @Column
    private Integer C_D_ID;
   // @Column
   // private Integer C_H_ID;
    @Column
    private String C_STRASSE;
    @Column
    private String C_STADT;
    @Column
    private String C_PLZ;
    @Column
    private String C_TELEFONNUMMER;
    @Column
    private Date C_KUNDESEIT;
    @Column
    private Double C_RABATT;
    @Column
    private Double C_KONTOSTAND;


    public Customer() {
    }


    @ManyToOne
    @JoinColumn(name = "C_D_ID", insertable=false, updatable = false)
    private District CustomerDistrict;

  //  @OneToOne
  //  @JoinColumn(name = "C_H_ID", insertable=false, updatable = false)
 //   private History CustomerHistory;


    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Order2> orders = new ArrayList<Order2>();

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
/*
    public Integer getC_H_ID() {
        return C_H_ID;
    }

    public void setC_H_ID(Integer c_H_ID) {
        C_H_ID = c_H_ID;
    }
*/
    public String getC_STRASSE() {
        return C_STRASSE;
    }

    public void setC_STRASSE(String c_STRASSE) {
        C_STRASSE = c_STRASSE;
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

    public District getCustomerDistrict() {
        return CustomerDistrict;
    }

    public void setCustomerDistrict(District customerDistrict) {
        CustomerDistrict = customerDistrict;
    }

  /*  public History getCustomerHistory() {
        return CustomerHistory;
    }

    public void setCustomerHistory(History customerHistory) {
        CustomerHistory = customerHistory;
    }
*/
    public List<Order2> getOrders() {
        return orders;
    }

    public void setOrders(List<Order2> orders) {
        this.orders = orders;
    }
}
