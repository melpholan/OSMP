package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GroupResultOfDoctorsCalls")
public class GroupResultOfDoctorsCalls implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCalls")
    private Long idGroupOfDoctorsCalls;

    public Long getIdGroupOfDoctorsCalls() {
        return idGroupOfDoctorsCalls;
    }

    public void setIdGroupOfDoctorsCalls(Long idGroupOfDoctorsCalls) {
        this.idGroupOfDoctorsCalls = idGroupOfDoctorsCalls;
    }

    @Column(name = "nameOfGroupResults")
    private String nameOfGroupResults;

    public String getNameOfGroupResults() {
        return nameOfGroupResults;
    }

    public void setNameOfGroupResults(String nameOfGroupResults) {
        this.nameOfGroupResults = nameOfGroupResults;
    }

    @OneToMany(mappedBy = "groupResultOfDoctorsCalls")
    private Set<ResultOfDoctorsCalls> resultOfDoctorsCalls = new HashSet<ResultOfDoctorsCalls>();

    public Set<ResultOfDoctorsCalls> getResultOfDoctorsCalls() {
        return this.resultOfDoctorsCalls;
    }

    public void setResultOfDoctorsCalls(Set<ResultOfDoctorsCalls> resultOfDoctorsCalls) {
        this.resultOfDoctorsCalls = resultOfDoctorsCalls;
    }

    public GroupResultOfDoctorsCalls() {
    }

    public GroupResultOfDoctorsCalls(String nameOfGroupResults) {
        this.nameOfGroupResults = nameOfGroupResults;
    }

    @Override
    public String toString() {
        return "GroupResultOfDoctorsCalls{" +
                "nameOfGroupResults='" + nameOfGroupResults + '\'' +
                '}';
    }
}
