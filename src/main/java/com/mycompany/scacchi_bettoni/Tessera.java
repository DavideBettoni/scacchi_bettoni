/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scacchi_bettoni;

import java.time.*;

/**
 *
 * @author STUDENTE
 */
public class Tessera
{
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private LocalDate dataVendita;
    private String tipologia;
    
    public  Tessera(String cognome,String nome,String codicefiscale,LocalDate datavendita, String tipologia)
   {
       this.cognome=cognome;
       this.nome=nome;
       this.codiceFiscale=codicefiscale;
       this.dataVendita=dataVendita;
       this.tipologia=tipologia;
   }
    public Tessera(Tessera t)
    {
        this.cognome=t.getCognome();
        this.nome=t.getNome();
        this.codiceFiscale=t.getCodiceFiscale();
        this.dataVendita=t.getDataVendita();
        this.tipologia=t.getTipologia();
    }

    public String getCognome() 
    {
        return cognome;
    }

    public String getNome() 
    {
        return nome;
    }

    public String getCodiceFiscale() 
    {
        return codiceFiscale;
    }

    public LocalDate getDataVendita()
    {
        return dataVendita;
    }

    public String getTipologia() 
    {
        return tipologia;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setDataVendita(LocalDate dataVendita) {
        this.dataVendita = dataVendita;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
   
    
}