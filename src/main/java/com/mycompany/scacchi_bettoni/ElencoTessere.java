/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scacchi_bettoni;

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
             ElencoTessere[i]=t.getVolume(i);
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
     public int setTessera (Tessera volume, int posizione)
    {
        if (posizione<0 || posizione>getNMaxTessere())
            return -1;  //pos non valida
        if(ElencoTessere[posizione]!=null)
            return -2;  //pos occupata
        
        //se posizione libera
        ElencoTessere[posizione]=new Tessera(volume);
        return posizione;
        
        
    }
    //restituisce una tessera che si trova in una posizione, se la posizione è vuota o nulla restituici -1
    public Tessera getVolume (int posizione)
    {
         if (posizione<0 || posizione>getNMaxTessere())
            return null;
         if(ElencoTessere[posizione]==null)
             return null;
         return new Tessera(ElencoTessere[posizione]);
    }
    public int rimuoviTessera(int anno, String codiceFiscale)
    {
        for(int i=0;i<getNMaxTessere();i++)
        {
            if(ElencoTessere[i].getCodiceFiscale().equalsIgnoreCase(codiceFiscale))
            {
                if(ElencoTessere[i].getAnno()==anno)
                {
                    ElencoTessere[i]=null;
                    
                    return 0;//eliminazione corretta
                }
                else
                    return -2;
            }  
        }
        return -1;
    }
    public int vissualizzaTessereConAnno(int anno)
    {
        for(int i=0;i<N_MAX_TESSERE;i++)
        {
            if(ElencoTessere[i].getAnno()==anno)
                {
                    System.out.println(ElencoTessere[i].toString());
                    return 0;
                }
                else
                return -1; //nessun abbonato in quell'anno
        }
        return 1;
    }
            
}
