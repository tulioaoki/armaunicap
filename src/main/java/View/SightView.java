package View;
import Controller.SightController;
import arma.Sight;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Dao.Dao;

@RequestScoped
@Path("sights")
@Produces("application/json")
public class SightView {
    
    SightController controller = new SightController();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sight postSight(Sight s){
        return controller.createSight(s);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Sight> listSight(){
        return controller.getSights();
    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Sight detailSight() throws NotFoundException{
        //@TODO DAO LOGIC HERE
        return null;
    }
    
    
    @Path("/{id}")
    @PUT
    public Sight updateSight(@PathParam("id") Integer id, Sight updatedSight) throws NotFoundException {
        updatedSight.setId(id);
        controller.updateSight(updatedSight);
        return null;
    }

    @Path("/{id}")
    @DELETE
    public void deleteSight(@PathParam("id") Integer id) {
        controller.removeSight(id);
    }
    
}
