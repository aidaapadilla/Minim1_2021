package edu.upc.dsa.services;


import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.exception.StationNotFoundException;
import edu.upc.dsa.exception.UserNotFoundException;
import edu.upc.dsa.models.Bicing;
import edu.upc.dsa.models.MyBike;
import edu.upc.dsa.models.Usuari;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;

@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class TracksService {

    private ManagerImpl manager = new ManagerImpl();

    /*public TracksService() {
        this.manager = (ManagerImpl) ManagerImpl.getInstance();
    }*/

    @PUT
    @ApiOperation(value = "New User")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Error User")
    })
    @Path("/user")
    public Response añadirUsuario(Usuari usuari) throws UserNotFoundException {
        String nom = usuari.getNomUsuari();
        String ID = usuari.getUsuariID();
        MyBike bike = usuari.getBike();
        Usuari nou = new Usuari(nom, ID, bike);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "New Station")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Error Station")
    })
    @Path("/newStation")
    public Response newStation(String station_name) throws StationNotFoundException {
        Bicing station = new Bicing(station_name);
        return Response.status(201).build();
    }
    @PUT
    @ApiOperation(value = "Add Bike")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Error Station")
    })
    @Path("/newBike")
    public Response addBike(MyBike bike) throws StationNotFoundException {
        int ID = bike.getID();
        double km=bike.getkm();
        String Station = bike.getStation();
        MyBike bike_new= new MyBike(ID,km,Station);
        return Response.status(201).build();
    }


    @GET
    @ApiOperation(value = "Get bike")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = MyBike.class),
            @ApiResponse(code = 404, message = "Error finding user")
    })
    @Path("/user/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBike(@PathParam("idUser") String idUser) throws UserNotFoundException {
        try {
            MyBike bike = manager.getBike(idUser);
            GenericEntity<MyBike> entity = new GenericEntity<MyBike>(bike) {
            };
            return Response.status(200).entity(entity).build();
        }
        catch(UserNotFoundException e){
            e.printStackTrace();
            return Response.status(404).build();
        }

    }

    @GET
    @ApiOperation(value = "Get bikes used by an user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = MyBike.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Error finding user")
    })
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesByUser(@PathParam("id") String id) {
        try {
            LinkedList<MyBike> bikes = manager.bikesByUser(id);
            GenericEntity<LinkedList<MyBike>> entity = new GenericEntity<LinkedList<MyBike>>(bikes) {
            };
            return Response.status(200).entity(entity).build();
        }
        catch(UserNotFoundException e){
            e.printStackTrace();
            return Response.status(404).build();
        }
    }
    @GET
    @ApiOperation(value = "Order bikes by station")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = MyBike.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Error finding station")
    })
    @Path("/{station}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbikesByStationOrderByKms(@PathParam("station") String station) {
        try {
            LinkedList<MyBike> lista = new LinkedList<MyBike>();
            manager.bikesByStationOrderByKms(station);
            GenericEntity<LinkedList<MyBike>> entity = new GenericEntity<LinkedList<MyBike>>(lista) {
            };
            return Response.status(200).entity(entity).build();
        }
        catch(StationNotFoundException e){
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    /*

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }





    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {

        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }*/

}