package ru.melpholan.osmp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DoctorsErrors")
public class DoctorsErrors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDoctorsErrors", nullable = false)
    private Long idDoctorsErrors;

    public Long getIdDoctorsErrors() {
        return idDoctorsErrors;
    }

    public void setIdDoctorsErrors(Long idDoctorsErrors) {
        this.idDoctorsErrors = idDoctorsErrors;
    }

    @Column(name = "errorsCharacter", nullable = false)
    private String errorsCharacter;

    public String getErrorsCharacter() {
        return errorsCharacter;
    }

    public void setErrorsCharacter(String errorsCharacter) {
        this.errorsCharacter = errorsCharacter;
    }

    @Column(name = "errorScales", nullable = false)
    private Integer errorScale;

    public Integer getErrorScale() {
        return errorScale;
    }

    public void setErrorScale(Integer errorScale) {
        this.errorScale = errorScale;
    }

    public DoctorsErrors() {
    }

    public DoctorsErrors(String errorsCharacter, Integer errorScale) {
        this.errorsCharacter = errorsCharacter;
        this.errorScale = errorScale;
    }

    @Override
    public String toString() {
        return "DoctorsErrors{" +
                "errorsCharacter='" + errorsCharacter + '\'' +
                ", errorScale=" + errorScale +
                '}';
    }
}
