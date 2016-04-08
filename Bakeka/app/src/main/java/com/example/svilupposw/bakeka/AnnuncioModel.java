package com.example.svilupposw.bakeka;

import java.util.Date;

public class AnnuncioModel {
    private String titolo;
    private String descrizione;
    private Date dataPubblicazione;
    private String imgBase64;
    private String uuid;

    public AnnuncioModel() {
    }

    public AnnuncioModel(String titolo, String descrizione, Date dataPubblicazione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataPubblicazione = dataPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
