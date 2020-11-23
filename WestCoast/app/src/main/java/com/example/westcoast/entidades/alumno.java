package com.example.westcoast.entidades;


public class alumno{

    private String nombreAlumno;
    private Integer matricula;
    private Integer edad;
    private String carrera;
    private Integer telefonoAlumno;
    private String emailAlumno;
    private String contrasenaAlumno;
    private String habilidadesAlumno;
    private String interesesAlumno;


    public alumno(String nombreAlumno, Integer matricula, Integer edad, String carrera, Integer telefonoAlumno, String emailAlumno, String contrasenaAlumno, String habilidadesAlumno, String interesesAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = carrera;
        this.telefonoAlumno = telefonoAlumno;
        this.emailAlumno = emailAlumno;
        this.contrasenaAlumno = contrasenaAlumno;
        this.habilidadesAlumno = habilidadesAlumno;
        this.interesesAlumno = interesesAlumno;

    }

    public alumno() {

    }


    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getTelefonoAlumno() {
        return telefonoAlumno;
    }

    public void setTelefonoAlumno(Integer telefonoAlumno) {
        this.telefonoAlumno = telefonoAlumno;
    }

    public String getEmailAlumno() {
        return emailAlumno;
    }

    public void setEmailAlumno(String emailAlumno) {
        this.emailAlumno = emailAlumno;
    }

    public String getContrasenaAlumno() {
        return contrasenaAlumno;
    }

    public void setContrasenaAlumno(String contrasenaAlumno) {
        this.contrasenaAlumno = contrasenaAlumno;
    }

    public String getHabilidadesAlumno() {
        return habilidadesAlumno;
    }

    public void setHabilidadesAlumno(String habilidadesAlumno) {
        this.habilidadesAlumno = habilidadesAlumno;
    }

    public String getInteresesAlumno() {
        return interesesAlumno;
    }

    public void setInteresesAlumno(String interesesAlumno) {
        this.interesesAlumno = interesesAlumno;
    }

    }

