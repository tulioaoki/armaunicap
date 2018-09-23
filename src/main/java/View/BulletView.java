package View;
import arma.Bullet;
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
@Path("Bullet")
@Produces("application/json")

public class BulletView {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postBullet(Bullet b) {
        return b.getName();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public ArrayList<Bullet> listBullet() {
       return null;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bullet detailBullet() {
        return null;
    }

    @Path("/{id}")
    @PUT

    public Bullet updateBullet(@PathParam("id") String id, Bullet updatedBullet) throws
            NotFoundException {
        return null;
// return BulletDao.updateBullet(id, updatedBullet);
    }

    @Path("/{id}")
    @DELETE

    public void deleteBullet(@PathParam("id") String id) {
// BulletDao.deleteBullet(id);
    }

}