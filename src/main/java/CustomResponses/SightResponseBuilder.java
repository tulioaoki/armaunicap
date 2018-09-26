package CustomResponses;

import Controller.SightController;
import arma.Sight;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class SightResponseBuilder implements ResponseBuilder {

    private SightController controller = new SightController();

    @Override
    public Response post(Object obj) {
        Sight item = (Sight) obj;
        item = controller.createSight(item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 201, "Sight criado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O id inserido já existe.", false, 400, "O Sight não pôde ser criado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response list() {
        ArrayList item = controller.getSights();
        CustomResponse r = new CustomResponse(item, true, 200, "Sights listados com sucesso.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response get(String id) {
        Sight item = controller.getById(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Sight retornado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Sight com id inserido não existe.", false, 400, "O Sight não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response put(String id, Object obj) {
        Sight item = (Sight) obj;
        item = controller.updateSight(id,item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Sight alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Sight com id inserido não existe.", false, 400, "O Sight não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response delete(String id) {
        boolean item = controller.removeSight(id);
        if (item) {
            CustomResponse r = new CustomResponse(item, true, 200, "Sight alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Sight com id inserido não existe.", false, 400, "O Sight não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }
}
