package com.uniroma3.esamesiw2024.model;

public class GiocatoreDTO {

    private Long id;
    private String nome;
    private String Cognome;
    private String data;
    private String luogoNascita;
    private String ruolo;
    private String dataInizioTess;
    private String dataFineTess;
    private SquadraDTO squadra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getDataInizioTess() {
        return dataInizioTess;
    }

    public void setDataInizioTess(String dataInizioTess) {
        this.dataInizioTess = dataInizioTess;
    }

    public String getDataFineTess() {
        return dataFineTess;
    }

    public void setDataFineTess(String dataFineTess) {
        this.dataFineTess = dataFineTess;
    }

    public SquadraDTO getSquadra() {
        return squadra;
    }

    public void setSquadra(SquadraDTO squadra) {
        this.squadra = squadra;
    }
}
