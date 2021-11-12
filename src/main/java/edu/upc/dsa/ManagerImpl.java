package edu.upc.dsa;

import edu.upc.dsa.exception.StationFullException;
import edu.upc.dsa.exception.StationNotFoundException;
import edu.upc.dsa.exception.UserNotFoundException;
import edu.upc.dsa.models.*;

import java.util.*;

public class ManagerImpl implements Manager {

    private LinkedList<MyBike> llistaBicicletes = new LinkedList<MyBike>();
    private Hashtable<String, Usuari> usuaris = new Hashtable<String, Usuari>();
    private Bicing[] llistaEstacions = new Bicing[100]; //private Station[] stations;
    private int num_estacions;

    private static ManagerImpl instance;
    /*public static Manager getInstance() {
        if (instance == null) instance = new ManagerImpl();
        return instance;
    }*/
    public int getNumeroUsuarios(){return usuaris.size();}
    public int getNumBicicletes(){return llistaBicicletes.size();}
    public int getNumEstacions(){return llistaEstacions.length;}

    public void añadirUsuario(Usuari usuari){
        usuaris.put(usuari.getUsuariID(), usuari);
    }
    public void addStation(Bicing station)
    {
        llistaEstacions[num_estacions]=station;
        num_estacions=num_estacions+1;
    }
    public void addBike(MyBike bike){
        llistaBicicletes.add(bike);
    }

    @Override
    public List<MyBike> bikesByStationOrderByKms(Bicing station) {
        return null;
    }

    @Override
    public MyBike getBike(Usuari usuari) {
        return null;
    }

    @Override
    public List<MyBike> bikesByUser(Usuari usuari) {
        return null;
    }

    private int getStationById(String stationId) throws StationNotFoundException {
        int i=0;
        while (i<this.getNumEstacions())
        {
            if (stationId.equals(this.llistaEstacions[i].getID())) {
                return i;
            }
            else
                i=i+1;
        }
        throw new StationNotFoundException();
    }
    public LinkedList<MyBike> bikesByStationOrderByKms(String station_name) throws StationNotFoundException {

        int station_position = this.getStationById(station_name);
        LinkedList<MyBike> listaOrdenada= this.llistaEstacions[station_position].getBicicletes();
        Collections.sort(listaOrdenada,new Comparator<MyBike>() {
            public int compare(MyBike o1, MyBike o2) {
                return (int) (o1.getkm() - o2.getkm());
            }
        });
        return listaOrdenada;
    }

    public MyBike getBike(String usuari) throws UserNotFoundException {
        Usuari usuari3=this.usuaris.get(usuari);

        if (usuari3 != null) {
            MyBike bike = usuari3.getBike(); //Aquesta es la bici que està fent servir
            return bike;
        } else {
            throw new UserNotFoundException();
        }

    }

    public LinkedList<MyBike> bikesByUser(String usuari) throws UserNotFoundException{
        Usuari usuari3=this.usuaris.get(usuari);

        if (usuari3 != null) {
            LinkedList<MyBike> llistabicisuser= usuari3.getLlistaBicis(); //Aquestes son les bicis que ha fet servir
            return llistabicisuser;
        } else {
            throw new UserNotFoundException();
        }
    };



}
