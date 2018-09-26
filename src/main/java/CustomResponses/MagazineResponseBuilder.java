package CustomResponses;

import Controller.MagazineController;
import arma.Bullet;
import arma.Magazine;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class MagazineResponseBuilder implements ResponseBuilder {

    private MagazineController controller = new MagazineController();

    @Override
    public Response post(Object obj) {
        Magazine item = (Magazine) obj;
        item = controller.createMagazine(item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 201, "Magazine criado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O id inserido já existe.", false, 400, "O Magazine não pôde ser criado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response list() {
        ArrayList item = controller.getMagazines();
        CustomResponse r = new CustomResponse(item, true, 200, "Magazines listados com sucesso.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response get(String id) {
        Magazine item = controller.getById(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Magazine retornado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Magazine com id inserido não existe.", false, 400, "O Magazine não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response put(String id, Object obj) {
        Magazine item = (Magazine) obj;
        item = controller.updateMagazine(id,item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Magazine alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Magazine com id inserido não existe.", false, 400, "O Magazine não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response delete(String id) {
        boolean item = controller.removeMagazine(id);
        if (item) {
            CustomResponse r = new CustomResponse(item, true, 200, "Magazine alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Magazine com id inserido não existe.", false, 400, "O Magazine não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response load(String id, String b) {
        Magazine item = controller.load(id, b);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Magazine alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A Bullet é incompatível ou não existe.", false, 400, "O Magazine não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response unload(String id) {
        Magazine item = controller.unload(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Magazine alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Magazine não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response addCompatibility(String id, String b) {
        Magazine item = controller.addCompatibility(id,b);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Magazine alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Magazine não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }
}
