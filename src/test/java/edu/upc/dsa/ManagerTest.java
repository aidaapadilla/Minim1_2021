package edu.upc.dsa;

import edu.upc.dsa.exception.StationNotFoundException;
import edu.upc.dsa.models.Bicing;
import edu.upc.dsa.models.MyBike;
import edu.upc.dsa.models.Usuari;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ManagerTest {
    private ManagerImpl manager;

    @Before
    public void setUp  () {
        manager = new ManagerImpl();
        MyBike bike = new MyBike(1,100,"Horta");
        MyBike bike2 = new MyBike(2,120, "Castefa");
        MyBike bike3 = new MyBike(3,130, "Horta");
        MyBike bike4 = new MyBike(4,140, "Castefa");
        manager.addBike(bike);
        manager.addBike(bike2);
        manager.addBike(bike3);
        manager.addBike(bike4);

        Usuari aida = new Usuari("Aida","11111111Z",bike3);
        manager.añadirUsuario(new Usuari("Joana","22222222X",bike));
        manager.añadirUsuario(new Usuari("Jordi","33333333Y",bike2));
        manager.añadirUsuario(aida);
        manager.añadirUsuario(new Usuari("Sergi","44444444R",bike4));

        Bicing station1 = new Bicing("Horta"); //Horta
        Bicing station2 = new Bicing("Castefa"); //Castefa
        station1.addBicicleta(bike);
        station1.addBicicleta(bike3);
        station2.addBicicleta(bike2);
        station2.addBicicleta(bike4);
        manager.addStation(station1);
        manager.addStation(station2);

        LinkedList<MyBike> listaOrdenada = (LinkedList<MyBike>) manager.bikesByStationOrderByKms(station1);
        MyBike biciAida = manager.getBike(aida);
        List<MyBike> bicisAida = manager.bikesByUser(aida);

    }

    @Test
    public void ProbaAñadirUsuario(){
        Assert.assertEquals(manager.getNumeroUsuarios(),4);
        MyBike bike5 = new MyBike(5,100,"honolulu");
        Usuari hey = new Usuari("Pepe","11111111T",bike5);
        manager.añadirUsuario(hey);
        Assert.assertEquals(manager.getNumeroUsuarios(),5);
    }
    @Test
    public void ProbaAddStation(){
        Assert.assertEquals(manager.getNumEstacions(),100);
        Bicing station3 = new Bicing("Horta"); //Horta
        manager.addStation(station3);
        Assert.assertEquals(manager.getNumEstacions(),100); //esta malament
    }
    @Test
    public void ProbaAddBike(){
        Assert.assertEquals(manager.getNumBicicletes(),4);
        MyBike bike2 = new MyBike(4,140, "Castefa");
        manager.addBike(bike2);
        Assert.assertEquals(manager.getNumBicicletes(),5);
    }

    @Test
    public void ProbaBikesByStationOrderByKms() throws StationNotFoundException {
        LinkedList<MyBike> llistaOrdenada=new LinkedList<MyBike>();
        MyBike bike5 = new MyBike(5,100,"honolulu");
        MyBike bike6 = new MyBike(6,120, "honolulu");
        MyBike bike7 = new MyBike(7,130, "honolulu");
        MyBike bike8 = new MyBike(8,140, "honolulu");
        Bicing station4 = new Bicing("Horta"); //Horta

        station4.addBicicleta(bike8);
        station4.addBicicleta(bike7);
        station4.addBicicleta(bike6);
        station4.addBicicleta(bike5);

        llistaOrdenada.add(bike5);
        llistaOrdenada.add(bike6);
        llistaOrdenada.add(bike7);
        llistaOrdenada.add(bike8);
        Assert.assertEquals(manager.bikesByStationOrderByKms("Horta"),llistaOrdenada);
    }
    @Test
    public void ProbaGetBike(){
        MyBike bike5 = new MyBike(5,100,"honolulu");
        Usuari ballenata2 = new Usuari("ballenata","123456789A",bike5);
        Assert.assertEquals(manager.getBike(ballenata2),bike5);
    }
    @Test
    public void ProbaBikesByUser(){
        MyBike bike5 = new MyBike(5,100,"honolulu");
        Usuari ballenata2 = new Usuari("ballenata","123456789A",bike5);
        MyBike bike6 = new MyBike(6,120, "honolulu");
        ballenata2.afegirBicileta(bike6);
        MyBike bike7 = new MyBike(7,130, "honolulu");
        ballenata2.afegirBicileta(bike7);
        MyBike bike8 = new MyBike(8,140, "honolulu");
        ballenata2.afegirBicileta(bike8);
        LinkedList<MyBike> llistaOrdenada=new LinkedList<MyBike>();
        llistaOrdenada.add(bike5);
        llistaOrdenada.add(bike6);
        llistaOrdenada.add(bike7);
        llistaOrdenada.add(bike8);
        Assert.assertEquals(manager.bikesByUser(ballenata2),llistaOrdenada);
    }

}
