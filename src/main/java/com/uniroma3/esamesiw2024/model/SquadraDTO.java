package com.uniroma3.esamesiw2024.model;


import java.util.List;

public class SquadraDTO {

    private Long id;
    private String Nome;
    private String dataFondazione;
    private String indirizzo;
    private List<GiocatoreDTO> giocatori;
    private PresidenteDTO presidente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDataFondazione() {
        return dataFondazione;
    }

    public void setDataFondazione(String dataFondazione) {
        this.dataFondazione = dataFondazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<GiocatoreDTO> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<GiocatoreDTO> giocatori) {
        this.giocatori = giocatori;
    }

    public PresidenteDTO getPresidente() {
        return presidente;
    }

    public void setPresidente(PresidenteDTO presidente) {
        this.presidente = presidente;
    }
}
