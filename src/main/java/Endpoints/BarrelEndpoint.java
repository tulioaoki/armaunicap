package Endpoints;
import CustomResponses.BarrelResponseBuilder;
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
import javax.ws.rs.core.Response;

@RequestScoped
@Path("barrels")
@Produces("application/json")
public class BarrelEndpoint {
    BarrelResponseBuilder response_manager = new BarrelResponseBuilder();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBarrel(Barrel b) {
        return response_manager.post(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBarrel() {
        return response_manager.list();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response detailBarrel(@PathParam("id") String id) {
        return response_manager.get(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBarrel(@PathParam("id") String id, Barrel updatedBarrel) throws NotFoundException {
        updatedBarrel.setId(id);
        return response_manager.put(id,updatedBarrel);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBarrel(@PathParam("id") String id) {
         response_manager.delete(id);
    }
}
