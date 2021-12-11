/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gardenapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranee
 */
public class Garden {

    static int n;
    static int k;
    static int sc;
    static int se;

    ArrayList<ArrayList<Plante>> plants = new ArrayList<ArrayList<Plante>>();

    public Garden(int n, int k, int sc, int se) {

        this.n = n;
        this.k = k;
        this.sc = sc;
        this.se = se;

        for (int x = 0; x < n; x++) {
            plants.add(new ArrayList<Plante>());

            for (int y = 0; y < n; y++) {

                if (y != k - 1) {
                    Plante px = new Plante(x, y ,k,"");
                    //im.get(x).add(y, "0");
                    plants.get(x).add(y, px);

                } else {
                    Plante px = new Plante(x, y ,k, "*");
                     plants.get(x).add(y,px);
                }

            }

        }
    }


    
    
    public void addPlant(Plante p ){
         int i =p.lp;
        int j =p.cp;
        if( j != k )
                plants.get(i-1).add(j-1,p);

            
    
    }
    
}
