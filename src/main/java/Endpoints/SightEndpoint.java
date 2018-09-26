package Endpoints;
import CustomResponses.SightResponseBuilder;
import arma.Sight;
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
@Path("sights")
@Produces("application/json")
public class SightEndpoint {

    SightResponseBuilder response_manager = new SightResponseBuilder();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBarrel(Sight b) {
        return response_manager.post(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listSight() {
        return response_manager.list();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response detailSight(@PathParam("id") String id) {
        return response_manager.get(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSight(@PathParam("id") String id, Sight updatedSight) throws NotFoundException {
        updatedSight.setId(id);
        return response_manager.put(id,updatedSight);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteSight(@PathParam("id") String id) {
        response_manager.delete(id);
    }
    
}