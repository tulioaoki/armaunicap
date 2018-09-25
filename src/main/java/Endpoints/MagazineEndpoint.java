package Endpoints;
import Controller.MagazineController;
import arma.Magazine;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
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

@ApplicationScoped
@Path("magazines")
@Produces("application/json")
public class MagazineEndpoint {
   
    MagazineController controller = new MagazineController();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Magazine postMagazine(Magazine b) {
        return controller.createMagazine(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Magazine> listMagazine() {
       return controller.getMagazines();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Magazine detailMagazine(@PathParam("id") String id) {
        return controller.getById(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Magazine updateMagazine(@PathParam("id") String id, Magazine updatedMagazine) throws NotFoundException {
        updatedMagazine.setId(id);
        return controller.updateMagazine(updatedMagazine);
    }
    
    @Path("/{id}/add-compatibility/{bullet}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Magazine addCompatibility(@PathParam("id") String id,@PathParam("bullet") String bullet) throws NotFoundException {
        return controller.addCompatibility(id, bullet);
    }
    
    @Path("/{id}/load/{bullet}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Magazine load(@PathParam("id") String id,@PathParam("bullet") String bullet) throws NotFoundException {
        return controller.load(id, bullet);
    }
    
    @Path("/{id}/unload")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Magazine unload(@PathParam("id") String id) throws NotFoundException {
        return controller.unload(id);
    }

    
    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteMagazine(@PathParam("id") String id) {
        controller.removeMagazine(id);
    }

}