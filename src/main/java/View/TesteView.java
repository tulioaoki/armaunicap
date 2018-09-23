package View;
import arma.Sight;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("teste")
@Produces("application/json")
public class TesteView {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Sight postSight(Sight s){
        Sight teste = new Sight("aa",1,3,1);
        return teste;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Sight> listSight(){
        //return sightDao.listSight();
        return null;
    }
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Sight detailSight(){
        Sight teste = new Sight("aa",1,3,1);
        return teste;
    }
    
    
    @Path("/{id}")
    @PUT
    public Sight updateSight(@PathParam("id") String id, Sight updatedSight) throws NotFoundException {
        return null;
        //return sightDao.updateSight(id, updatedSight);
    }

    @Path("/{id}")
    @DELETE
    public void deleteSight(@PathParam("id") String id) {
        //sightDao.deleteSight(id);
    }
    
}
