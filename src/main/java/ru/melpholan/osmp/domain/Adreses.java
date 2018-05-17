package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Adreses")
public class Adreses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdress")
    private Long idAdress;

    @Column(name = "sity")
    private String sity;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private Integer houseNumber;

    @Column(name = "p_flat")
    private Integer flatNumber;

    @OneToOne(mappedBy = "adress")
    private Passport passport;

    public Passport getPassport() {
        return this.passport;
    }

    public void setPassport(Passport passport) {
        passport.setAdress(this);
        this.passport = passport;
    }

    //constructor without parameters
    public Adreses(){}


    public Long getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(Long idAdress) {
        this.idAdress = idAdress;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Adreses{" +
                "idAdress=" + idAdress +
                ", sity='" + sity + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adreses adreses = (Adreses) o;

        if (!getIdAdress().equals(adreses.getIdAdress())) return false;
        if (!getSity().equals(adreses.getSity())) return false;
        if (!getStreet().equals(adreses.getStreet())) return false;
        if (!getHouseNumber().equals(adreses.getHouseNumber())) return false;
        if (getFlatNumber() != null ? !getFlatNumber().equals(adreses.getFlatNumber()) : adreses.getFlatNumber() != null)
            return false;
        return getPassport() != null ? getPassport().equals(adreses.getPassport()) : adreses.getPassport() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdAdress().hashCode();
        result = 31 * result + getSity().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getHouseNumber().hashCode();
        result = 31 * result + (getFlatNumber() != null ? getFlatNumber().hashCode() : 0);
        result = 31 * result + (getPassport() != null ? getPassport().hashCode() : 0);
        return result;
    }
}
