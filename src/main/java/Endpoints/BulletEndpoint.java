package Endpoints;
import CustomResponses.BulletResponseBuilder;
import arma.Bullet;

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
@Path("bullets")
@Produces("application/json")
public class BulletEndpoint {
    BulletResponseBuilder response_manager = new BulletResponseBuilder();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBarrel(Bullet b) {
        return response_manager.post(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listBullet() {
        return response_manager.list();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response detailBullet(@PathParam("id") String id) {
        return response_manager.get(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBullet(@PathParam("id") String id, Bullet updatedBullet) throws NotFoundException {
        updatedBullet.setId(id);
        return response_manager.put(id,updatedBullet);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBullet(@PathParam("id") String id) {
        response_manager.delete(id);
    }

}