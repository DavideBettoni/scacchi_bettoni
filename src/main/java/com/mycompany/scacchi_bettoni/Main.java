/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scacchi_bettoni;

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
        int anno,mese,giorno;
        LocalDate data;
        
       Scanner tastiera= new Scanner(System.in);
       String[] vociMenu= new String[7];
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "crea nuova tessera";
        vociMenu[2] = "elimina una tessera";
        vociMenu[3] = "visualizzare gli anni dei tesserati in base a nome e cognome";
        vociMenu[4] = "visualizzare tesserati in base all'anno";
        vociMenu[5] = "Visualizza tesserati senior in ordine alfabetico";
        vociMenu[6] = "salva le tessere su file";
        
        Menu menu= new Menu(vociMenu);
        Tessera tessera = null;
        
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
                 
                }
                 case 2:
                {
                
                }
                 case 3:
                {
                  
                }
                 case 4:
                {
                    
                }
                 case 5:
                {
                   
                }
                 case 6:
                 {
                     
                 }
            }
            
        }while (sceltaUtente<0 || sceltaUtente>=6);
    }
}