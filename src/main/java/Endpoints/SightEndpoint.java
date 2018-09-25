package Endpoints;
import Controller.SightController;
import arma.Sight;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("sights")
@Produces("application/json")
public class SightEndpoint {
    
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
    
    @Path("/{id}/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Sight detailSight(@PathParam("id") String id) throws NotFoundException{
        return controller.getById(id);
    }
    
    
    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Sight updateSight(@PathParam("id") String id, Sight updatedSight) throws NotFoundException {
        updatedSight.setId(id);
        return controller.updateSight(updatedSight);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteSight(@PathParam("id") String id) {
        controller.removeSight(id);
    }
    
}