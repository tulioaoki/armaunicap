package Endpoints;
import Controller.BarrelController;
import arma.Barrel;
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
@Path("barrels")
@Produces("application/json")
public class BarrelEndpoint {
    BarrelController controller = new BarrelController();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Barrel postBarrel(Barrel b) {
        return controller.createBarrel(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Barrel> listBarrel() {
        return controller.getBarrels();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Barrel detailBarrel(@PathParam("id") String id) {
        return controller.getById(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Barrel updateBarrel(@PathParam("id") String id, Barrel updatedBarrel) throws NotFoundException {
        updatedBarrel.setId(id);
        return controller.updateBarrel(updatedBarrel);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBarrel(@PathParam("id") String id) {
         controller.removeBarrel(id);
    }
}
