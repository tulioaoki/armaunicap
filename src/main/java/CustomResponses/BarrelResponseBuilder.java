package CustomResponses;

import Controller.BarrelController;
import arma.Barrel;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class BarrelResponseBuilder implements ResponseBuilder {

    private BarrelController controller = new BarrelController();

    @Override
    public Response post(Object obj) {
        Barrel item = (Barrel) obj;
        item = controller.createBarrel(item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 201, "Barrel criado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O id inserido já existe.", false, 400, "O Barrel não pôde ser criado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response list() {
        ArrayList item = controller.getBarrels();
        CustomResponse r = new CustomResponse(item, true, 200, "Barrels listados com sucesso.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response get(String id) {
        Barrel item = controller.getById(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Barrel retornado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Barrel com id inserido não existe.", false, 400, "O Barrel não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response put(String id, Object obj) {
        Barrel item = (Barrel) obj;
        item = controller.updateBarrel(id,item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Barrel alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Barrel com id inserido não existe.", false, 400, "O Barrel não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response delete(String id) {
        boolean item = controller.removeBarrel(id);
        if (item) {
            CustomResponse r = new CustomResponse(item, true, 200, "Barrel alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Barrel com id inserido não existe.", false, 400, "O Barrel não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }
}
