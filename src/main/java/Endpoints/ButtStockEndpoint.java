package Endpoints;
import CustomResponses.BSResponseBuilder;
import CustomResponses.BulletResponseBuilder;
import arma.Bullet;
import arma.ButtStock;

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
@Path("buttstocks")
@Produces("application/json")
public class ButtStockEndpoint {
    BSResponseBuilder response_manager = new BSResponseBuilder();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBarrel(ButtStock b) {
        return response_manager.post(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listButtStock() {
        return response_manager.list();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response detailButtStock(@PathParam("id") String id) {
        return response_manager.get(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateButtStock(@PathParam("id") String id, ButtStock updatedButtStock) throws NotFoundException {
        updatedButtStock.setId(id);
        return response_manager.put(id,updatedButtStock);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteButtStock(@PathParam("id") String id) {
        response_manager.delete(id);
    }
}
