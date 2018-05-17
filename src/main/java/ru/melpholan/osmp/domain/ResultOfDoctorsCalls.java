package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ResultOfDoctorsCalls")
public class ResultOfDoctorsCalls implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResultOfDoctorCalls")
    private Long idResultOfDoctorCalls;

    public Long getIdResultOfDoctorCalls() {
        return idResultOfDoctorCalls;
    }

    public void setIdResultOfDoctorCalls(Long idResultOfDoctorCalls) {
        this.idResultOfDoctorCalls = idResultOfDoctorCalls;
    }

    @Column(name = "typeOfResult")
    private String typeOfResult;

    public String getTypeOfResult() {
        return typeOfResult;
    }

    public void setTypeOfResult(String typeOfResult) {
        this.typeOfResult = typeOfResult;
    }

    @ManyToOne
    @JoinColumn(name = "GroupResultOfDoctorsCalls_idCalls")
    private GroupResultOfDoctorsCalls groupResultOfDoctorsCalls;

    public GroupResultOfDoctorsCalls getGroupResultOfDoctorsCalls() {
        return this.groupResultOfDoctorsCalls;
    }

    public void setGroupResultOfDoctorsCalls(GroupResultOfDoctorsCalls groupResultOfDoctorsCalls) {
        this.groupResultOfDoctorsCalls = groupResultOfDoctorsCalls;
    }

    public ResultOfDoctorsCalls() {
    }

    public ResultOfDoctorsCalls(String typeOfResult, GroupResultOfDoctorsCalls groupResultOfDoctorsCalls) {
        this.typeOfResult = typeOfResult;
        this.groupResultOfDoctorsCalls = groupResultOfDoctorsCalls;
    }

    @Override
    public String toString() {
        return "ResultOfDoctorsCalls{" +
                "typeOfResult='" + typeOfResult + '\'' +
                //   ", groupResultOfDoctorsCalls=" + groupResultOfDoctorsCalls +
                '}';
    }
}
