package Endpoints;
import CustomResponses.MagazineResponseBuilder;
import arma.Magazine;
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
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("magazines")
@Produces("application/json")
public class MagazineEndpoint {

    MagazineResponseBuilder response_manager = new MagazineResponseBuilder();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBarrel(Magazine b) {
        return response_manager.post(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMagazine() {
        return response_manager.list();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response detailMagazine(@PathParam("id") String id) {
        return response_manager.get(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMagazine(@PathParam("id") String id, Magazine updatedMagazine) throws NotFoundException {
        updatedMagazine.setId(id);
        return response_manager.put(id,updatedMagazine);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteMagazine(@PathParam("id") String id) {
        response_manager.delete(id);
    }

    @Path("/{id}/add-compatibility/{bullet}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompatibility(@PathParam("id") String id,@PathParam("bullet") String bullet) throws NotFoundException {
        return response_manager.addCompatibility(id, bullet);
    }
    
    @Path("/{id}/load/{bullet}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response load(@PathParam("id") String id,@PathParam("bullet") String bullet) throws NotFoundException {
        return response_manager.load(id, bullet);
    }
    
    @Path("/{id}/unload")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response unload(@PathParam("id") String id) throws NotFoundException {
        return response_manager.unload(id);
    }
}