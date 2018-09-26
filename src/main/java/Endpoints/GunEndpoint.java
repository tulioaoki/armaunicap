package Endpoints;
import CustomResponses.GunResponseBuilder;
import arma.Gun;
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
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("guns")
@Produces("application/json")
public class GunEndpoint {
    
    GunResponseBuilder response_manager = new GunResponseBuilder();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postGun(Gun b) {

        return response_manager.post(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGun() {
       return response_manager.list();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response detailGun(@PathParam("id") String id) {
        return response_manager.get(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGun(@PathParam("id") String id, Gun updatedGun) throws NotFoundException {
        updatedGun.setId(id);
        return response_manager.put(id,updatedGun);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteGun(@PathParam("id") String id) {
        response_manager.delete(id);
    }
    
    //ADD/PUTS
    @Path("/{id}/put-barrel/{barrel}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putBarrel(@PathParam("id") String id,@PathParam("barrel") String barrel) throws NotFoundException {
        return response_manager.putBarrel(id, barrel);
    }
    
    @Path("/{id}/put-bt/{bt}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putBt(@PathParam("id") String id,@PathParam("bt") String bt) throws NotFoundException {
        return response_manager.putButtStock(id, bt);
    }
    
    @Path("/{id}/put-magazine/{magazine}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putMagazine(@PathParam("id") String id,@PathParam("magazine") String magazine) throws NotFoundException {
        return response_manager.putMagazine(id, magazine);
    }
    
    @Path("/{id}/put-sight/{sight}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putSight(@PathParam("id") String id,@PathParam("sight") String sight) throws NotFoundException {
        return response_manager.putSight(id, sight);
    }
    
    //REMOVES 
    @Path("/{id}/remove-barrel")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBarrel(@PathParam("id") String id) throws NotFoundException {
        return response_manager.delBarrel(id);
    }
    
    @Path("/{id}/remove-bt")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delBt(@PathParam("id") String id) throws NotFoundException {
        return response_manager.delButtStock(id);
    }
    
    @Path("/{id}/remove-magazine")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delMagazine(@PathParam("id") String id) throws NotFoundException {
        return response_manager.delMagazine(id);
    }
    
    @Path("/{id}/remove-sight")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delSight(@PathParam("id") String id) throws NotFoundException {
        return response_manager.delSight(id);
    }
    //END REMOVES
    
    
    //COMPATIBILITY
    @Path("/{id}/compatibility-barrel/{item}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompatibilityBarrel(@PathParam("id") String id, @PathParam("item") String item) throws NotFoundException {
        return response_manager.addCompatibilityBarrel(id, item);
    }
    
    @Path("/{id}/compatibility-bt/{item}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompatibilityButtStock(@PathParam("id") String id,@PathParam("item") String item) throws NotFoundException {
        return response_manager.addCompatibilityBt(id, item);
    }
    
    @Path("/{id}/compatibility-magazine/{item}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompatibilityMagazine(@PathParam("id") String id,@PathParam("item") String item) throws NotFoundException {
        return response_manager.addCompatibilityMagazine(id, item);
    }
    
    @Path("/{id}/compatibility-sight/{item}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompatibilitySight(@PathParam("id") String id,@PathParam("item") String item) throws NotFoundException {
        return response_manager.addCompatibilitySight(id, item);
    }

}