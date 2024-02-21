package com.uniroma3.esamesiw2024.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Squadra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "squadraid")
    @SequenceGenerator(name="squadraid", sequenceName = "squadraid", allocationSize = 1)
    private Long id;
    private String Nome;
    private String dataFondazione;
    private String indirizzo;
    @OneToMany(mappedBy="squadra" ,cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Giocatore> giocatori;
    @OneToOne(cascade = CascadeType.ALL)
    private Presidente presidente;

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

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(List<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }

    public Presidente getPresidente() {
        return presidente;
    }

    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }
}
