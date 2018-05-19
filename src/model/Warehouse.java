package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

    @Entity
    @Table(name = "WAREHOUSE")
    public class Warehouse implements Serializable {
        @Id
        private Integer W_ID;
        @Column
        private String W_NAME;
        @Column
        private String W_STRAßE;
        @Column
        private String W_STADT;
        @Column
        private Integer W_PLZ;
        @Column
        private Double W_STEUERSATZ;


        public Warehouse() {
        }

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

        public String getW_STRAßE() {
            return W_STRAßE;
        }

        public void setW_STRAßE(String w_STRAßE) {
            W_STRAßE = w_STRAßE;
        }

        public String getW_STADT() {
            return W_STADT;
        }

        public void setW_STADT(String w_STADT) {
            W_STADT = w_STADT;
        }

        public Integer getW_PLZ() {
            return W_PLZ;
        }

        public void setW_PLZ(Integer w_PLZ) {
            W_PLZ = w_PLZ;
        }

        public Double getW_STEUERSATZ() {
            return W_STEUERSATZ;
        }

        public void setW_STEUERSATZ(Double w_STEUERSATZ) {
            W_STEUERSATZ = w_STEUERSATZ;
        }
    }