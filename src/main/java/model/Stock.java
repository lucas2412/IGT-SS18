package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {
    @Id
    private Integer S_I_ID;
    @Id
    private Integer S_W_ID;
    @Column
    private Integer S_QUANTITY;
    @Column
    private String S_DIST_01;
    @Column
    private String S_DIST_02;
    @Column
    private String S_DIST_03;
    @Column
    private String S_DIST_04;
    @Column
    private String S_DIST_05;
    @Column
    private String S_DIST_06;
    @Column
    private String S_DIST_07;
    @Column
    private String S_DIST_08;
    @Column
    private String S_DIST_09;
    @Column
    private String S_DIST_10;
    @Column
    private Integer S_YTD;
    @Column
    private Integer S_ORDER_CNT;
    @Column
    private Integer S_REMOTE_CNT;

    public Stock() {
    }


    public Integer getS_I_ID() {
        return S_I_ID;
    }

    public void setS_I_ID(Integer s_I_ID) {
        S_I_ID = s_I_ID;
    }

    public Integer getS_W_ID() {
        return S_W_ID;
    }

    public void setS_W_ID(Integer s_W_ID) {
        S_W_ID = s_W_ID;
    }

    public Integer getS_QUANTITY() {
        return S_QUANTITY;
    }

    public void setS_QUANTITY(Integer s_QUANTITY) {
        S_QUANTITY = s_QUANTITY;
    }

    public String getS_DIST_01() {
        return S_DIST_01;
    }

    public void setS_DIST_01(String s_DIST_01) {
        S_DIST_01 = s_DIST_01;
    }

    public String getS_DIST_02() {
        return S_DIST_02;
    }

    public void setS_DIST_02(String s_DIST_02) {
        S_DIST_02 = s_DIST_02;
    }

    public String getS_DIST_03() {
        return S_DIST_03;
    }

    public void setS_DIST_03(String s_DIST_03) {
        S_DIST_03 = s_DIST_03;
    }

    public String getS_DIST_04() {
        return S_DIST_04;
    }

    public void setS_DIST_04(String s_DIST_04) {
        S_DIST_04 = s_DIST_04;
    }

    public String getS_DIST_05() {
        return S_DIST_05;
    }

    public void setS_DIST_05(String s_DIST_05) {
        S_DIST_05 = s_DIST_05;
    }

    public String getS_DIST_06() {
        return S_DIST_06;
    }

    public void setS_DIST_06(String s_DIST_06) {
        S_DIST_06 = s_DIST_06;
    }

    public String getS_DIST_07() {
        return S_DIST_07;
    }

    public void setS_DIST_07(String s_DIST_07) {
        S_DIST_07 = s_DIST_07;
    }

    public String getS_DIST_08() {
        return S_DIST_08;
    }

    public void setS_DIST_08(String s_DIST_08) {
        S_DIST_08 = s_DIST_08;
    }

    public String getS_DIST_09() {
        return S_DIST_09;
    }

    public void setS_DIST_09(String s_DIST_09) {
        S_DIST_09 = s_DIST_09;
    }

    public String getS_DIST_10() {
        return S_DIST_10;
    }

    public void setS_DIST_10(String s_DIST_10) {
        S_DIST_10 = s_DIST_10;
    }

    public Integer getS_YTD() {
        return S_YTD;
    }

    public void setS_YTD(Integer s_YTD) {
        S_YTD = s_YTD;
    }

    public Integer getS_ORDER_CNT() {
        return S_ORDER_CNT;
    }

    public void setS_ORDER_CNT(Integer s_ORDER_CNT) {
        S_ORDER_CNT = s_ORDER_CNT;
    }

    public Integer getS_REMOTE_CNT() {
        return S_REMOTE_CNT;
    }

    public void setS_REMOTE_CNT(Integer s_REMOTE_CNT) {
        S_REMOTE_CNT = s_REMOTE_CNT;
    }
}


