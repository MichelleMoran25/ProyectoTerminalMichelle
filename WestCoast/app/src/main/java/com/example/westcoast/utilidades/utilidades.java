package com.example.westcoast.utilidades;

public class utilidades{

    //constantes para los campos de la tabla alumnos

    public static String TABLA_ALUMNO = "alumno";
    public static String CAMPO_NOMBREALUMNO = "nombreAlumno";
    public static String CAMPO_MATRICULA = "matricula";
    public static String CAMPO_EDAD = "edad";
    public static String CAMPO_CARRERA = "carrera";
    public static String CAMPO_TELEFONOALUMNO = "telefonoAlumno";
    public static String CAMPO_EMAILALUMNO = "emailAlumno";
    public static String CAMPO_CONTRASENAALUMNO = "contrasena";
    public static String CAMPO_HABILIADESALUMNO = "habilidadesAlumno";
    public static String CAMPO_INTERESESALUMNO = "interesesAlumno";


    //Script para la tabla alumno
    public static final String CREAR_TABLA_ALUMNO = "CREATE TABLE " + " "+TABLA_ALUMNO+" ("+CAMPO_NOMBREALUMNO+" TEXT, "+CAMPO_MATRICULA+" INTEGER, "+CAMPO_EDAD+" INTEGER, "+CAMPO_CARRERA+" TEXT, "+CAMPO_TELEFONOALUMNO+" INTEGER, "+CAMPO_EMAILALUMNO+" TEXT, "+CAMPO_CONTRASENAALUMNO+" TEXT, "+CAMPO_HABILIADESALUMNO+" TEXT, "+CAMPO_INTERESESALUMNO+" TEXT)";


    //Constantes para los datos de la tabla empresa

    public static String TABLA_EMPRESA = "empresa";
    public static String CAMPO_RFC = "rfc";
    public static String CAMPO_NOMBREEMPRESA = "nombreEmpresa";
    public static String CAMPO_DIRECCIONEMPRESA = "direccionEmpresa";
    public static String CAMPO_CPEMPRESA = "cpEmpresa";
    public static String CAMPO_TELEFONOEMPRESA = "telefonoEmpresa";
    public static String CAMPO_EMAILEMPRESA = "emailEmpresa";
    public static String CAMPO_CONTRAEMPRESA = "contrasenaEmpresa";
    public static String CAMPO_DESCRIPCIONEMPRESA = "descripcionEmpresa";


    //Script para la tabla empresa
    public static final String CREAR_TABLA_EMPRESA = "CREATE TABLE" + " "+TABLA_EMPRESA+" ("+CAMPO_RFC+" TEXT, "+CAMPO_NOMBREEMPRESA+" TEXT, "+CAMPO_DIRECCIONEMPRESA+" TEXT, "+CAMPO_CPEMPRESA+" INTEGER, "+CAMPO_TELEFONOEMPRESA+" INTEGER, "+CAMPO_EMAILEMPRESA+" TEXT, "+CAMPO_CONTRAEMPRESA+" TEXT, "+CAMPO_DESCRIPCIONEMPRESA+" TEXT)";


    //Constantes para los datos de la tabla Oferta
    public static String TABLA_OFERTA = "oferta";
    public static String CAMPO_NAMEOFERTA = "nombreOferta";
    public static String CAMPO_NAMEMPRESA = "nombreempresa";
    public static String CAMPO_UBICACIONEMPRESA = "ubicacionEmpresa";
    public static String CAMPO_DESCRIPCIONOFERTA = "descripcionoerta";
    public static String CAMPO_AREAOFERTA = "areaOferta";
    public static String CAMPO_CONTACTO = "contacto";
    public static String CAMPO_CODIEMPRESA = "codi_empresa";


    //Script para la tabla oferta
    public static final String CREAR_TABLA_OFERTA = "CREATE TABLE" + " "+TABLA_OFERTA+" ("+CAMPO_NAMEOFERTA+" TEXT, "+CAMPO_NAMEMPRESA+" TEXT, "+CAMPO_UBICACIONEMPRESA+" TEXT, "+CAMPO_DESCRIPCIONOFERTA+" TEXT, "+CAMPO_AREAOFERTA+" TEXT, "+CAMPO_CONTACTO+" TEXT, "+CAMPO_CODIEMPRESA+" TEXT)";


}
