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
                    
                }
                case 1:
                {
                   
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
            
        }

