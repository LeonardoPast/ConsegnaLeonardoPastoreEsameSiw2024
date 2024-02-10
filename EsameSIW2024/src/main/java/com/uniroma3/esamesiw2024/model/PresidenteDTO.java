package com.uniroma3.esamesiw2024.model;

public class PresidenteDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String codicePostale;
    private String dataNascita;
    private String luogoNascita;
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
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodicePostale() {
        return codicePostale;
    }

    public void setCodicePostale(String codicePostale) {
        this.codicePostale = codicePostale;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public SquadraDTO getSquadra() {
        return squadra;
    }

    public void setSquadra(SquadraDTO squadra) {
        this.squadra = squadra;
    }
}
