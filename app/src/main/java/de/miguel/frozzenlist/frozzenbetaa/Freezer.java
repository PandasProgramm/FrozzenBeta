package de.miguel.frozzenlist.frozzenbetaa;

import java.util.ArrayList;

   /**
    =============================================
    @author Miguel Gutierrez, project FrozzenList
    @version 1.0Beta
    @param: model: Freezerobject
    =============================================

 */

public class Freezer {


    private String name;
    public int tray;
    private ArrayList<Tray>trays;


    //Instance
    public Freezer(String name, int tray) {
        this.name = name;
        this.tray=tray;
        trays= new ArrayList<Tray>();
        for(int i= 0;i<tray;i++){
            trays.add(new Tray());
        }
    }
    public String getName(){
        return name;
    }


       @Override
       public String toString() {
           return  name +" hat " + tray +" Fächer";
       }

   }
