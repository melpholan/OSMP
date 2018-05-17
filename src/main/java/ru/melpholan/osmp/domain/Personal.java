package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Personal")
public class Personal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonal")
    private Long idPersonal;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_surname")
    private String surname;

    @Column(name = "p_patronymic")
    private String patronymic;

    @OneToMany(mappedBy = "personal")
    List<Shifts> shifts;

    public List<Shifts> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shifts> shifts) {
        this.shifts = shifts;
    }

    public void addShift(Shifts shift){
        shift.setPersonal(this);
        this.getShifts().add(shift);
    }

    //mapping to Passport
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Passport_idPassport")
    private Passport passport;

    public Passport getPassport(){
        return this.passport;
    }

    public void setPassport(Passport passport){
        this.passport = passport;
    }


    //-----------------------------------------------------------//
    //constructor without parameters
    public Personal(){}

    // getters and setters
    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    // toString
    @Override
    public String toString() {
        return "Personal{" +
                "idPersonal=" + idPersonal +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Personal)) return false;

        final Personal personal = (Personal) o;

        if (!getName().equals(personal.getName())) return false;
        if((getSurname() == null) && (personal.getSurname() == null)){
            return true;
        }
        return getSurname().equals(personal.getSurname());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        return result;
    }


}
