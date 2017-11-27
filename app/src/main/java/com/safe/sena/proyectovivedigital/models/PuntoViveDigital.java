package com.safe.sena.proyectovivedigital.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PuntoViveDigital {

    @SerializedName("coordenadas_pvd_validadas")
    @Expose
    private Cordenada coordenadas_pvd_validadas;

    @SerializedName("departamento")
    @Expose
    private String departamento;

    @SerializedName("direcci_n_pvd")
    @Expose
    private String direcci_n_pvd;

    @SerializedName("ejecutor")
    @Expose
    private String ejecutor;

    @SerializedName("el_punto_ya_fue_donado_si_no")
    @Expose
    private String el_punto_ya_fue_donado_si_no;

    @SerializedName("escritura_de_donaci_n")
    @Expose
    private String escritura_de_donaci_n;

    @SerializedName("estado_actual_de_la_carpeta")
    @Expose
    private String estado_actual_de_la_carpeta;

    @SerializedName("fase")
    @Expose
    private String fase;

    @SerializedName("fecha_de_convenio")
    @Expose
    private String fecha_de_convenio;

    @SerializedName("horario_atenci_n_del_pvd")
    @Expose
    private String horario_atenci_n_del_pvd;

    @SerializedName("integrador_de_servicio")
    @Expose
    private String integrador_de_servicio;

    @SerializedName("municipio")
    @Expose
    private String municipio;

    @SerializedName("tipo_de_beneficiario")
    @Expose
    private String tipo_de_beneficiario;

    @SerializedName("tipo_ejecutor")
    @Expose
    private String tipo_ejecutor;

    @SerializedName("tipologia")
    @Expose
    private String tipologia;


    public Cordenada getCoordenadas_pvd_validadas() {
        return coordenadas_pvd_validadas;
    }

    public void setCoordenadas_pvd_validadas(Cordenada coordenadas_pvd_validadas) {
        this.coordenadas_pvd_validadas = coordenadas_pvd_validadas;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDirecci_n_pvd() {
        return direcci_n_pvd;
    }

    public void setDirecci_n_pvd(String direcci_n_pvd) {
        this.direcci_n_pvd = direcci_n_pvd;
    }

    public String getEjecutor() {
        return ejecutor;
    }

    public void setEjecutor(String ejecutor) {
        this.ejecutor = ejecutor;
    }

    public String getEl_punto_ya_fue_donado_si_no() {
        return el_punto_ya_fue_donado_si_no;
    }

    public void setEl_punto_ya_fue_donado_si_no(String el_punto_ya_fue_donado_si_no) {
        this.el_punto_ya_fue_donado_si_no = el_punto_ya_fue_donado_si_no;
    }

    public String getEscritura_de_donaci_n() {
        return escritura_de_donaci_n;
    }

    public void setEscritura_de_donaci_n(String escritura_de_donaci_n) {
        this.escritura_de_donaci_n = escritura_de_donaci_n;
    }

    public String getEstado_actual_de_la_carpeta() {
        return estado_actual_de_la_carpeta;
    }

    public void setEstado_actual_de_la_carpeta(String estado_actual_de_la_carpeta) {
        this.estado_actual_de_la_carpeta = estado_actual_de_la_carpeta;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getFecha_de_convenio() {
        return fecha_de_convenio;
    }

    public void setFecha_de_convenio(String fecha_de_convenio) {
        this.fecha_de_convenio = fecha_de_convenio;
    }

    public String getHorario_atenci_n_del_pvd() {
        return horario_atenci_n_del_pvd;
    }

    public void setHorario_atenci_n_del_pvd(String horario_atenci_n_del_pvd) {
        this.horario_atenci_n_del_pvd = horario_atenci_n_del_pvd;
    }

    public String getIntegrador_de_servicio() {
        return integrador_de_servicio;
    }

    public void setIntegrador_de_servicio(String integrador_de_servicio) {
        this.integrador_de_servicio = integrador_de_servicio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTipo_de_beneficiario() {
        return tipo_de_beneficiario;
    }

    public void setTipo_de_beneficiario(String tipo_de_beneficiario) {
        this.tipo_de_beneficiario = tipo_de_beneficiario;
    }

    public String getTipo_ejecutor() {
        return tipo_ejecutor;
    }

    public void setTipo_ejecutor(String tipo_ejecutor) {
        this.tipo_ejecutor = tipo_ejecutor;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}


