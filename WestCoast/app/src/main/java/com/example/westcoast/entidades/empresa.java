package com.example.westcoast.entidades;

public class empresa {

    private String nombreEmpresa;
    private String direccionEmpresa;
    private Integer cpEmpresa;
    private Integer telEmpresa;
    private String emailEmpresa;
    private String contrasenaEmpresa;
    private String descripcionEmpresa;
    private String id_rfc;



    public empresa(String nombreEmpresa, String direccionEmpresa, Integer cpEmpresa, Integer telEmpresa, String emailEmpresa, String contrasenaEmpresa, String descripcionEmpresa, String id_rfc) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.cpEmpresa = cpEmpresa;
        this.telEmpresa = telEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.contrasenaEmpresa = contrasenaEmpresa;
        this.descripcionEmpresa = descripcionEmpresa;
        this.id_rfc = id_rfc;

    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public Integer getCpEmpresa() {
        return cpEmpresa;
    }

    public void setCpEmpresa(Integer cpEmpresa) {
        this.cpEmpresa = cpEmpresa;
    }

    public Integer getTelEmpresa() {
        return telEmpresa;
    }

    public void setTelEmpresa(Integer telEmpresa) {
        this.telEmpresa = telEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getContrasenaEmpresa() {
        return contrasenaEmpresa;
    }

    public void setContrasenaEmpresa(String contrasenaEmpresa) {
        this.contrasenaEmpresa = contrasenaEmpresa;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public String getId_rfc() {
        return id_rfc;
    }

    public void setId_rfc(String id_rfc) {
        this.id_rfc = id_rfc;
    }

    }

