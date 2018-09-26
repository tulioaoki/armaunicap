package CustomResponses;

import Controller.BulletController;
import arma.Bullet;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class BulletResponseBuilder implements ResponseBuilder {

    private BulletController controller = new BulletController();

    @Override
    public Response post(Object obj) {
        Bullet item = (Bullet) obj;
        item = controller.createBullet(item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 201, "Bullet criado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O id inserido já existe.", false, 400, "O Bullet não pôde ser criado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response list() {
        ArrayList item = controller.getBullets();
        CustomResponse r = new CustomResponse(item, true, 200, "Bullets listados com sucesso.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response get(String id) {
        Bullet item = controller.getById(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Bullet retornado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Bullet com id inserido não existe.", false, 400, "O Bullet não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response put(String id,Object obj) {
        Bullet item = (Bullet) obj;
        item = controller.updateBullet(id,item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Bullet alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Bullet com id inserido não existe.", false, 400, "O Bullet não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response delete(String id) {
        boolean item = controller.removeBullet(id);
        if (item) {
            CustomResponse r = new CustomResponse(item, true, 200, "Bullet alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Bullet com id inserido não existe.", false, 400, "O Bullet não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }
}