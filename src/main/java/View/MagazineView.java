package View;
import arma.Magazine;
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
@Path("magazine")
@Produces("application/json")
public class MagazineView {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Magazine postMagazine(Magazine b) {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Magazine> listMagazine() {
       return null;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Magazine detailMagazine() {
        return null;
    }

    @Path("/{id}")
    @PUT

    public Magazine updateMagazine(@PathParam("id") String id, Magazine updatedMagazine) throws
            NotFoundException {
        return null;
// return MagazineDao.updateMagazine(id, updatedMagazine);
    }

    @Path("/{id}")
    @DELETE

    public void deleteMagazine(@PathParam("id") String id) {
// MagazineDao.deleteMagazine(id);
    }

}