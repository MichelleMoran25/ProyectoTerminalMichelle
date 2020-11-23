package com.example.westcoast.entidades;

public class oferta {

    private String nombreOferta;
    private String nombreempresa;
    private String codi_oferta;
    private String ubicacionEmpresa;
    private String descripcionoerta;
    private String areaOferta;
    private String contacto;

    public oferta(String nombreOferta, String nombreempresa, String codi_oferta, String ubicacionEmpresa, String descripcionoerta, String areaOferta, String contacto) {
        this.nombreOferta = nombreOferta;
        this.nombreempresa = nombreempresa;
        this.ubicacionEmpresa = ubicacionEmpresa;
        this.descripcionoerta = descripcionoerta;
        this.contacto = contacto;
        this.areaOferta = areaOferta;
        this.codi_oferta = codi_oferta;
    }

    public oferta(){

    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getUbicacionEmpresa() {
        return ubicacionEmpresa;
    }

    public void setUbicacionEmpresa(String ubicacionEmpresa) {
        this.ubicacionEmpresa = ubicacionEmpresa;
    }

    public String getDescripcionoerta() {
        return descripcionoerta;
    }

    public void setDescripcionoerta(String descripcionoerta) {
        this.descripcionoerta = descripcionoerta;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCodi_oferta() {
        return codi_oferta;
    }

    public void setCodi_oferta(String codi_oferta) {
        this.codi_oferta = codi_oferta;
    }

    public String getAreaOferta() {
        return areaOferta;
    }

    public void setAreaOferta(String areaOferta) {
        this.areaOferta = areaOferta;
    }



}





