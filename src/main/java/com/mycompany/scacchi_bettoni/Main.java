/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scacchi_bettoni;

import java.util.Scanner;

/**
 *
 * @author STUDENTE
 */
public class Main {
    public static void main(String[] args) 
    {
        int sceltaUtente;
        
       Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[6];
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "crea nuova tessera";
        vociMenu[2] = "elimina una tessera";
        vociMenu[3] = "visualizzare gli anni dei tesserati in base a nome e cognome";
        vociMenu[4] = "visualizzare tesserati in base all'anno";
        vociMenu[5] = "Visualizza tesserati senior in ordine alfabetico";
        vociMenu[6] = "salva le tessere su file";
        
        Menu menu= new Menu(vociMenu);
        
        
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
                    //aggiunta libro a unos scaffale
                    libro = new Libro();
                   
                    System.out.println("Titolo--> ");
                    libro.setTitolo(tastiera.nextLine());
                    System.out.println("Autore--> ");
                    libro.setAutore(tastiera.nextLine());
                    System.out.println("N pagine--> ");
                    libro.setPagine(tastiera.nextInt());
                    System.out.println("ripiano [1..4]--> ");
                    ripiano = tastiera.nextInt();
                    System.out.println("posizione [1..14]--> ");
                    posizione = tastiera.nextInt();
                    esitoOperazione = s1.setLibro(libro,ripiano ,posizione );
                    if (esitoOperazione == 0)
                        System.out.println("inserimento avvenuto correttamente!");
                    else if (esitoOperazione == -1)
                        System.out.println("inserimento non effettuato!");
                    if (esitoOperazione == -2)
                        System.out.println("posizione occupata!");
                    if (esitoOperazione == -3)
                        System.out.println("ripiano non valido!");
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                 case 2:
                {
                    //visualizza libro
                    System.out.println("ripiano [1..4]--> ");
                    ripiano = tastiera.nextInt();
                    System.out.println("posizione [1..14]--> ");
                    posizione = tastiera.nextInt();
                    libro =s1.getLibro(ripiano, posizione);
                    if (libro == null)
                        System.out.println("nessun libro presente in questa posizione");
                    else 
                        System.out.println(libro.toString());
                    System.out.println("premi un pulsante per continuare.");
                    tastiera.nextLine();
                    break;
                }
                 case 3:
                {
                    //elimina libro
                    System.out.println("ripiano [1..4]-->");
                    ripiano = tastiera.nextInt();
                    System.out.println("posizione [1..14]-->");
                    posizione = tastiera.nextInt();
                    esitoOperazione = s1.rimuoviLibro(ripiano, posizione);
                    if(esitoOperazione == 0)
                        System.out.println("libro eliminato correttamente");
                    else if(esitoOperazione == -1)
                        System.out.println("poszione non valida");
                    else if(esitoOperazione == -2)
                        System.out.println("nella posizone indicata non c'e' nessun libro");
                    else
                        System.out.println("il ripiano indicato non e' valido");
                    tastiera.nextLine();
                    System.out.println("premi un pulsante per continuare.");
                    tastiera.nextLine();
                    break;
                }
                 case 4:
                {
                    //cerca libro in base  ad Autore
                    String[] elencoTitoli;
                    String autore;
                    System.out.println("Autore--> ");
                    autore = tastiera.nextLine();
                    elencoTitoli = s1.elencoTitoliAutore(autore);
                    if (elencoTitoli == null)
                        System.out.println("nessun libro di "+autore);
                    else
                    {
                        for (int i=0;i<elencoTitoli.length;i++)
                             System.out.println(elencoTitoli[i]);
                    }
                    System.out.println("premi un pulsante per continuare.");
                    tastiera.nextLine();
                    break;
                }
                 case 5:
                {
                    System.out.println(s1.toString()); 
                    System.out.println("premi un pulsante per continuare.");
                    tastiera.nextLine();
                    break;
                }
                 case 6:
                 {
                     System.out.println(s1.elencoAlfabeticoLibri());
                     break;
                 }
                 case 7:
                 {
                     Libro[] elencoLibri;
                     elencoLibri=s1.elencoLibriOrdinatiPrezzo();
                     for(int i=0;i<elencoLibri.length;i++)
                     {
                         System.out.println(elencoLibri[i].toString() +" € " + elencoLibri[i].prezzo());
                     }
                     break;
                 }
                 case 8:
                 {
                     Libro[] elencoLibri;
                     elencoLibri=s1.elencoLibriAlfabeticoAutoreTitolo();
                     for(int i=0;i<elencoLibri.length;i++)
                     {
                         System.out.println(elencoLibri[i].toString() +" € " + elencoLibri[i].prezzo());
                     }
                     break;
                 }
            }
            
        }while(sceltaUtente!=0);  
    }
}
