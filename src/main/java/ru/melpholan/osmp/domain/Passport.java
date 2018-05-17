package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Passport")
public class Passport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPassport")
    private Long idPassport;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthsday;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_date_of_work_license")
    private Date lastDateOfWorkLicense;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_employment")
    private Date dateOfEmployment;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_dismissal")
    private Date dateOfDimissal;


    //mapping to Personal
    @OneToOne(mappedBy = "passport",cascade = CascadeType.ALL)
    private Personal personal;

    //mapping to Contacts
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Contacts_idContacts")
    private Contacts contacts;

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    //mapping to Address
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Adreses_idAdress")
    private Adreses adress;

    public Adreses getAdreses(){
        return this.adress;
    }
    public void setAdress(Adreses adress){
        this.adress = adress;
    }

    public Adreses getAdress() {
        return this.adress;
    }


    //constructor
    public Passport(){}

//    public Passport(Date birthsday, Date lastDateOfWorkLicense, Date dateOfEmployment, Date dateOfDimissal, Adreses adress, Contacts contacts) {
//        this.birthsday = birthsday;
//        this.lastDateOfWorkLicense = lastDateOfWorkLicense;
//        this.dateOfEmployment = dateOfEmployment;
//        this.dateOfDimissal = dateOfDimissal;
//        this.adress = adress;
//        this.contacts = contacts;
//    }

    public Long getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(Long idPassport) {
        this.idPassport = idPassport;
    }

    public Date getBirthsday() {
        return birthsday;
    }

    public void setBirthsday(Date birthsday) {
        this.birthsday = birthsday;
    }

    public Date getLastDateOfWorkLicense() {
        return lastDateOfWorkLicense;
    }

    public void setLastDateOfWorkLicense(Date lastDateOfWorkLicense) {
        this.lastDateOfWorkLicense = lastDateOfWorkLicense;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Date getDateOfDimissal() {
        return dateOfDimissal;
    }

    public void setDateOfDimissal(Date dateOfDimissal) {
        this.dateOfDimissal =  dateOfDimissal;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "idPassport=" + idPassport +
                ", birthsday'" + birthsday + '\'' +
                ", lastDateOfWorkLicense: '" + lastDateOfWorkLicense + '\'' +
                ", dateOfEmployment: '" + dateOfEmployment + '\'' +
                '}';
    }
}
