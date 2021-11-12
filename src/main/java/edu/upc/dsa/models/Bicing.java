package edu.upc.dsa.models;
import edu.upc.dsa.models.MyBike;

import java.util.LinkedList;
import java.util.List;

public class Bicing {
    String ID;
    int numBicicletes=0;
    int numBicicletes_Available=0;
    LinkedList<MyBike> llistabicicletes= new LinkedList<MyBike>();
    public Bicing (String ID)
    {
        this.ID = ID;
    }
    public void addBicicleta(MyBike bike){
        this.llistabicicletes.add(bike);
        this.numBicicletes=this.numBicicletes+1;

        if(bike.getAvailable()==1){
            this.numBicicletes_Available=this.numBicicletes_Available+1;
        }
    }
    public LinkedList<MyBike> getBicicletes(){
        return this.llistabicicletes;
    }
    public String getID(){return ID;};
    public int getNumBicicletes(){return numBicicletes;}
    public int searchAvailable(){
        return numBicicletes_Available;
    }
}
