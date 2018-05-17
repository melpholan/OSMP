package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Contacts")
public class Contacts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacts")
    private Long idContacts;

    @Column(name = "phone_home")
    private String homePhone;

    @Column(name = "phone_mobile")
    private String mobilePhone;

    @Column(name = "email")
    private String emil;

    //Personal
    @OneToOne(mappedBy = "contacts")
    private Passport passport;

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }


    public Long getIdContacts() {
        return idContacts;
    }

    public void setIdContacts(Long idContacts) {
        this.idContacts = idContacts;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }


    public Contacts(){}

    @Override
    public String toString() {
        return "Contacts{" +
                "idContacts=" + idContacts +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", emil='" + emil + '\'' +
                ", personal=" + passport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacts)) return false;

        final Contacts contacts = (Contacts) o;

        if (!getEmil().equals(contacts.getEmil())) return false;
        return getMobilePhone().equals(contacts.getMobilePhone());
    }
}
