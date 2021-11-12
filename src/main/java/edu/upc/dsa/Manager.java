package edu.upc.dsa;

import edu.upc.dsa.exception.UserNotFoundException;
import edu.upc.dsa.models.Bicing;
import edu.upc.dsa.models.Usuari;
import edu.upc.dsa.models.MyBike;

import java.util.List;

public interface Manager {
    public void añadirUsuario(Usuari usuari) throws UserNotFoundException; //DONE
    public void addStation(Bicing station); //DONE
    public void addBike(MyBike bike); //DONE
    public List<MyBike> bikesByStationOrderByKms(Bicing station); //DONE
    public MyBike getBike(Usuari usuari); //Done
    public List<MyBike> bikesByUser(Usuari usuari); //Done

}
