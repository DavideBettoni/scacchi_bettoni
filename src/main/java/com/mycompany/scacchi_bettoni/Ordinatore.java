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
public class Ordinatore 
{
    public static void  scambia(Tessera v[],int posizione1, int posizione2)
    {
        Tessera c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    
     
    public static void  scambia(String v[],int posizione1, int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void  scambia(int v[],int posizione1, int posizione2)
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
}
