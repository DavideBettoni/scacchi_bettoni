/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scacchi_bettoni;

import Eccezioni.EccezionePosizioneNonValida;
import file.FileExeption;
import file.TextFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author STUDENTE
 */
public class ElencoTessere 
{
    private Tessera[] ElencoTessere;
    private static int N_MAX_TESSERE=15;
    private int n_tessere_presenti;
    
    public ElencoTessere()
     {
       ElencoTessere=new Tessera[N_MAX_TESSERE];
       
     }
    //costruttore di copia
    public ElencoTessere (ElencoTessere t)
    {
         ElencoTessere=new Tessera[N_MAX_TESSERE];
         for(int i=0;i<getNMaxTessere();i++)
         {
             ElencoTessere[i]=t.getTesserato(i);
         }
    }
    //costruttore array
    public ElencoTessere(Tessera ElencoTessere[])
    {
        ElencoTessere=new Tessera[N_MAX_TESSERE];
        int numeroLibri=0;
        //se elenco libri non contiene libri
        if(ElencoTessere.length==0)
            return;
        if(ElencoTessere.length>getNMaxTessere())
            numeroLibri=getNMaxTessere();
        else
            numeroLibri=ElencoTessere.length;
        
        for(int i=0;i<numeroLibri;i++)
        {
            if(ElencoTessere[i]!=null)
            {
                ElencoTessere[i]=new Tessera(ElencoTessere[i]);
            }
        }
    }
    public static int getNMaxTessere()
    {
        return N_MAX_TESSERE;
    }
     public int getNTessera()
    {
        int c=0;
        for (int i=0;i<N_MAX_TESSERE;i++)
        {
            if(ElencoTessere[i]!=null)
                c++;
            
        }
        return c;
    }
     public int setTessera (Tessera tessera, int posizione)
    {
        if (posizione<0 || posizione>getNMaxTessere())
            return -1;  //pos non valida
        if(ElencoTessere[posizione]!=null)
            return -2;  //pos occupata
        
        //se posizione libera
        ElencoTessere[posizione]=new Tessera(tessera);
        n_tessere_presenti++;
        return posizione;
        
        
    }
    public Tessera getTesserato (int posizione)
    {
         if (posizione<0 || posizione>getNMaxTessere())
            return null;
         if(ElencoTessere[posizione]==null)
             return null;
         return new Tessera(ElencoTessere[posizione]);
    }
    public int rimuoviTessera(String codiceFiscale)
    {
        for(int i=0;i<=n_tessere_presenti;i++)
        {
            if (codiceFiscale==null)
            {
                break;
            }
            if (ElencoTessere[i]==null)
            {
                break;
            }
            if(ElencoTessere[i].getCodiceFiscale().equalsIgnoreCase(codiceFiscale))
            {
                    ElencoTessere[i]=ElencoTessere[n_tessere_presenti];
                    ElencoTessere[n_tessere_presenti]=null;
                    
                    return 0;//eliminazione corretta
            }  
        }
        return -1;
    }
    public int vissualizzaTessereConAnno(int sceltaAnno)
    {
        int c=0;
        for(int i=0;i<N_MAX_TESSERE;i++)
        {
            if (ElencoTessere[i]==null)
            {
                break;  
            }
            if(ElencoTessere[i].getDataVendita().getYear()==sceltaAnno)
                {
                    System.out.println(ElencoTessere[i].toString());
                    c++;
                }
        }
        if (c==0)
            return -1;
        else 
            return 1;
    }
     public void esportaTesseratiCsv(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileExeption
    {
      TextFile f1= new TextFile(nomeFile, 'W');
      String rigaDaScrivere="";
      Tessera a;
      for(int i=0;i<getNMaxTessere();i++)
      {
              if(getTesserato(i)!=null)
              {
                  a=getTesserato(i);
                  rigaDaScrivere=" Cognome:"+a.getCognome()+"; Nome:"+a.getNome()+";  Codice: "+a.getCodiceFiscale()+";  Tipologia: "+a.getTipologia()+"; Data vendita: "+a.getDataVendita()+";";
                  
                  try 
                  {
                      f1.toFile(rigaDaScrivere);
                  } 
                  catch (FileExeption ex) 
                  {
                      f1.close();
                      throw new FileExeption("Errore in scrittura!");
                  }
              }
          
      }
      f1.close(); 
    }
    public void salvaElenco(String nomeFile) throws FileNotFoundException, IOException
    {
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream outputStream=new ObjectOutputStream(f1);
      outputStream.writeObject(this);
      outputStream.flush();
      outputStream.close();
    }
    
    public ElencoTessere caricaElencoTesserati(String nomeFile) throws FileNotFoundException, IOException, FileExeption 
    {
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream inputStream=new ObjectInputStream(f1);
        ElencoTessere e;
        try 
        {
           e=(ElencoTessere)inputStream.readObject();
           inputStream.close();
            return e;
        } 
       catch (ClassNotFoundException ex) 
       {
          inputStream.close();
          throw new FileExeption("Errore nella lettura del file");
       }
       
    }
    public String elencoAlfabeticoTessere(int sceltaAnno)
    {
        
        String s="";
        String elencoAbbonati[]=new String[getNTessera()];
        int c=0;
        Tessera tessera;
        for(int i=0;i<getNMaxTessere();i++)
        {
                if(getTesserato(i)!=null)
                {
                    if(sceltaAnno==ElencoTessere[i].getDataVendita().getYear())
                {
                    tessera=getTesserato(i);
                    elencoAbbonati[c]=tessera.toString();
                    c++;
                }
                    
                }
            
        }
        if(c==0)
            System.out.println("Nessun abbonamento presente");
        elencoAbbonati=Ordinatore.selectionSortCrescente(elencoAbbonati);
        for(int i=0;i<elencoAbbonati.length;i++)
        { 
            s=s+elencoAbbonati[i]+"\n"; 
        }     
    return s; 
    }
    
    
}