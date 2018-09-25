package Endpoints;
import Controller.BulletController;
import arma.Bullet;
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

@RequestScoped
@Path("bullets")
@Produces("application/json")
public class BulletEndpoint {
    
    BulletController controller = new BulletController();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Bullet postBullet(Bullet b) {
        return controller.createBullet(b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Bullet> listBullet() {
       return controller.getBullets();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bullet detailBullet(@PathParam("id") String id) {
        return controller.getById(id);
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Bullet updateBullet(@PathParam("id") String id, Bullet updatedBullet) throws NotFoundException {
        updatedBullet.setId(id);
        return controller.updateBullet(updatedBullet);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBullet(@PathParam("id") String id) {
        controller.removeBullet(id);
    }

}