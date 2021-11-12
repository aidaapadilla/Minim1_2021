package edu.upc.dsa.models;

import edu.upc.dsa.exception.StationFullException;

public class MyBike {
    int ID;
    int available; //Si es igual a 0 no està disponible, si es igual a 1 si ho està
    double km; //Et diu la carrega de la bicicleta
    String Station;

    public MyBike(int ID,double km,String station) //Ens servirà per afegir bicis
    {
        this.ID = ID;
        this.available=1;
        this.km=km;
        this.Station=station;
    }
    public String getStation(){return this.Station;}
    public void setID(int ID){
        this.ID=ID;
    }
    public void setAvailable(int available){
        if(available==0 || available==1) {
            this.available = available;
        }
        else
        {
            this.available=0;
        }
    }
    public void setKm(double carrega){
        this.km=km;
    }
    public int getAvailable(){return this.available;}
    public double getkm(){return this.km;}
    public int getID(){return this.ID;}
}
