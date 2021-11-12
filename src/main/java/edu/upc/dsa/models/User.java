package edu.upc.dsa.models;

public class User {
    private String name;
    private String ID;

    public User(String name1, String ID1)
    {
        this.ID = ID1;
        this.name = name1;
    }
    public String getName(){return name;}
    public String getID(){return ID;}
    public void setName(String name){this.name = name;}
    public void setID(String ID){this.ID = ID;}

}
