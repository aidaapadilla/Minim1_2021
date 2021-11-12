package edu.upc.dsa.models;

import java.util.Comparator;

public class bikesByStationOrderByKms implements Comparator<MyBike> {

    public int compare(MyBike p1, MyBike p2){

        return (int)(p1.getkm() - p2.getkm());

    }
}

