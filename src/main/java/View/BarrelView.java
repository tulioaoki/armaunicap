package View;

import arma.Barrel;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.websocket.server.PathParam;
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
@Path("barrel")
@Produces("application/json")
public class BarrelView {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Barrel postBarrel(Barrel b) {
        //@TODO DAO LOGIC HERE
        return b;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Barrel> listBarrel() {
        //@TODO DAO LOGIC HERE
        return null;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Barrel detailBarrel() {
        //@TODO DAO LOGIC HERE
        return null;
    }

    @Path("/{id}")
    @PUT

    public Barrel updateBarrel(@PathParam("id") String id, Barrel updatedBarrel) throws
            NotFoundException {
        return null;
        // return BarrelDao.updateBarrel(id, updatedBarrel);
    }

    @Path("/{id}")
    @DELETE
    public void deleteBarrel(@PathParam("id") String id) {
        // BarrelDao.deleteBarrel(id);
    }

}
