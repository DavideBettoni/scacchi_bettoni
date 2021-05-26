/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scacchi_bettoni;


import Eccezioni.EccezionePosizioneNonValida;
import file.FileExeption;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author STUDENTE
 */
public class Main {
    public static void main(String[] args) 
    {
        int sceltaUtente;
        int posizione=0;
        int sceltaAnno;
        String sceltaCodice;
        LocalDate data;
        String nomeFileBinario="elencotesserati.bin";
        String nomeFileCSV="Tesserati.txt";
        ElencoTessere e1=new ElencoTessere();
        
       Scanner tastiera= new Scanner(System.in);
       String[] vociMenu= new String[7];
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "crea nuova tessera";
        vociMenu[2] = "elimina una tessera";
        vociMenu[3] = "visualizzare tesserati in base all'anno";
        vociMenu[4] = "Visualizza tesserati senior in ordine alfabetico";
        vociMenu[5] = "sesporta su file CSV";
        vociMenu[6] = "salva dati";
        Menu menu= new Menu(vociMenu);
        Tessera tessera = null;
        
         try 
        {
            e1=e1.caricaElencoTesserati(nomeFileCSV);
            System.out.println("Dati caricati correttamente");
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file. I dati non sono stati caricati");
        }
        catch (FileExeption ex) 
        {
            System.out.println("Errore di lettura dal file. I dati non sono stati caricati");
        }
        
        do
        {
            sceltaUtente=menu.sceltaMenu();
            switch(sceltaUtente)
            {
                case 0:
                {
                 System.out.println("L'applicazione terminerà");
                 break;   
                }
                case 1:
                {
                tessera=new Tessera();    
                 tessera= new Tessera();
                 System.out.println("cognome--> ");
                 tessera.setCognome(tastiera.nextLine());  
                 System.out.println("Nome--> ");
                 tessera.setNome(tastiera.nextLine()); 
                 System.out.println("codice fiscale--> ");
                 tessera.setCodiceFiscale(tastiera.nextLine()); 
                 System.out.println("giorno di vendita--> ");
                 tessera.setGiorno(tastiera.nextInt());
                 System.out.println("mese di vendita--> ");
                 tessera.setMese(tastiera.nextInt());
                 System.out.println("anno di vendita--> ");
                 tessera.setAnno(tastiera.nextInt());
                 tastiera.nextLine();
                 System.out.println("tipologia tessera--> ");
                 tessera.setTipologia(tastiera.nextLine());
                 tessera.setDataVendita();
                 
                 e1.setTessera(tessera, posizione);
                 
                 System.out.println("Premi un pulsante per continuare");
                 posizione++;
                 break;
                }
                 case 2:
                {
                    tastiera.nextLine();
                    System.out.println("inserire codice fiscale della tessera da eliminare");
                    sceltaCodice=tastiera.nextLine();
                    e1.rimuoviTessera(sceltaCodice);
                    System.out.println("Premi un pulsante per continuare");
                    
                    
                }
                 case 3:
                {
                    System.out.println("anno: ");
                    sceltaAnno=(tastiera.nextInt());
                    e1.vissualizzaTessereConAnno(sceltaAnno);
                    tastiera.nextLine();
                }
                 case 4:
                {
                    
                    System.out.println("inserire anno: ");
                    sceltaAnno=(tastiera.nextInt());
                    e1.elencoAlfabeticoTessere(sceltaAnno);
                    break;
                }
                 case 5:
                {
                 try
                     {
                        e1.esportaTesseratiCsv(nomeFileCSV);
                        System.out.println("esportazione avvenuta correttamente!");
                     }
                     catch(IOException ec1)
                     {
                         System.out.println("Impossibile accedere al file, i libri non sono stati salvati.");
                     }
                     catch(EccezionePosizioneNonValida | FileExeption  ec2)
                     {
                         System.out.println(ec2.toString());
                     }
                 
                     break;  
                }
                 case 6:
                 {
                     try 
                    {
                        e1.salvaElenco(nomeFileBinario);
                        System.out.println("Dati salvati correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile accedere al file. I dati non sono stati salvati");  
                    }
                    break;
                 }
            }
            
        }while (sceltaUtente!=0);
    }
}