package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Shifts")
public class Shifts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShifts", nullable = false)
    private Long idShifts;

    public Long getIdShifts() {
        return idShifts;
    }

    public void setIdShifts(Long idShifts) {
        this.idShifts = idShifts;
    }


    @Temporal(TemporalType.DATE)
    @Column(name = "workDate")
    private Date workDate;

    //mapping to Personal
    @ManyToOne
    @JoinColumn(name = "Personal_idPersonal")
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    //mapping to ShiftTypes
    @ManyToOne
    @JoinColumn(name = "ShiftTypes_idShiftTypes")
    private ShiftTypes shiftTypes;

    public ShiftTypes getShiftTypes() {
        return this.shiftTypes;
    }

    public void setShiftTypes(ShiftTypes shiftTypes){
        this.shiftTypes = shiftTypes;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Shifts(){}

    @Override
    public int hashCode() {
        int result = getIdShifts().hashCode();
        result = 31 * result + shiftTypes.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Shifts{" +
                "idShifts=" + idShifts +
                ", Shifts='" + this.getShiftTypes() + '\'' +
                ", ShiftDate= " + this.getWorkDate() +
                '}';
    }
}
