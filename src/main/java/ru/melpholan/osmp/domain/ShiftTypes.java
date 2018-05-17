package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ShiftTypes")
public class ShiftTypes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShiftTypes")
    private Long idShiftTypes;

    @Column(name = "shiftName")
    private String shiftName;

    @Column(name = "hoursCuantity")
    private Integer hoursQuantity;


    //mapping to Shifts
    @OneToMany(mappedBy = "shiftTypes")
    private Set<Shifts> shifts = new HashSet<Shifts>();

    public Set<Shifts> getShifts(){
        return this.shifts;
    }

    public void setShifts(Set<Shifts> shifts){
        this.shifts=shifts;
    }

    public ShiftTypes(){}

    public ShiftTypes(String shiftName, Integer hoursQuantity) {
        this.shiftName = shiftName;
        this.hoursQuantity = hoursQuantity;
    }

    public Long getIdShiftTypes() {
        return idShiftTypes;
    }

    public void setIdShiftTypes(Long idShiftTypes) {
        this.idShiftTypes = idShiftTypes;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public Integer getHoursQuantity() {
        return hoursQuantity;
    }

    public void setHoursQuantity(Integer hoursQuantity) {
        this.hoursQuantity = hoursQuantity;
    }

    @Override
    public String toString() {
        return "ShiftTypes{ " +
                "shiftName=" + shiftName +
                ", hoursQuantity=" + hoursQuantity +
                '}';
    }
}
