package View;
import arma.ButtStock;
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
@Path("buttstock")
@Produces("application/json")

public class ButtStockView {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postButtStock(ButtStock b) {
        return b.getName();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public ArrayList<ButtStock> listButtStock() {
       return null;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ButtStock detailButtStock() {
        return null;
    }

    @Path("/{id}")
    @PUT

    public ButtStock updateButtStock(@PathParam("id") String id, ButtStock updatedButtStock) throws
            NotFoundException {
        return null;
// return ButtStockDao.updateButtStock(id, updatedButtStock);
    }

    @Path("/{id}")
    @DELETE

    public void deleteButtStock(@PathParam("id") String id) {
// ButtStockDao.deleteButtStock(id);
    }

}
