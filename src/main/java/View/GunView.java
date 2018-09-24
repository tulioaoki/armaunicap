package View;
import arma.Gun;
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
@Path("guns")
@Produces("application/json")
public class GunView {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Gun postGun(Gun b) {
        return b;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Gun> listGun() {
       return null;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Gun detailGun(@PathParam("id") String id) {
        return controller.getById(id);
    }

    @Path("/{id}")
    @PUT

    public Gun updateGun(@PathParam("id") String id, Gun updatedGun) throws NotFoundException {
        updatedGun.setId(id);
        return controller.updateGun(updatedGun);
    }

    @Path("/{id}")
    @DELETE
    public void deleteGun(@PathParam("id") String id) {
        controller.removeSight(id);
    }
    
    @Path("/{id}/put-style/{style}")
    @PUT
    public Gun addStyle(@PathParam("id") String id,@PathParam("style") String style) throws NotFoundException {
        return controller.putStyle(id, style);
    }
    
    @Path("/{id}/remove-style")
    @PUT
    public Gun delStyle(@PathParam("id") String id) throws NotFoundException {
        return controller.delStyle(id);
    }

}