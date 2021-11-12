package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Usuari {

    String nomusuari;
    String usuariID;
    LinkedList<MyBike> llistaBicis = new LinkedList<MyBike>();
    MyBike bike;

    public Usuari(String nomusuari, String usuariID, MyBike bike) {
        this.nomusuari = nomusuari;
        this.usuariID=usuariID;
        this.bike=bike;
        llistaBicis.add(bike);
    }

    public String getNomUsuari(){return this.nomusuari;}
    public void setUsuari(String nom) {
        this.nomusuari = nom;
    }

    public String getUsuariID(){
            return this.usuariID;
    }

    public void afegirBicileta(MyBike bike_nova){

        this.llistaBicis.add(bike_nova);
        this.bike=bike_nova;
    }
    public MyBike getBike(){return this.bike;}
    public LinkedList<MyBike> getLlistaBicis(){
            return this.llistaBicis;
        }
    }


