package CustomResponses;

import Controller.GunController;
import arma.Gun;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class GunResponseBuilder implements ResponseBuilder {

    private GunController controller = new GunController();

    @Override
    public Response post(Object obj) {
        Gun item = (Gun) obj;
        item = controller.createGun(item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 201, "Gun criado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O id inserido já existe.", false, 400, "O Gun não pôde ser criado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response list() {
        ArrayList item = controller.getList();
        CustomResponse r = new CustomResponse(item, true, 200, "Guns listados com sucesso.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response get(String id) {
        Gun item = controller.getById(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun retornado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Gun com id inserido não existe.", false, 400, "O Gun não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response put(String id, Object obj) {
        Gun item = (Gun) obj;
        item = controller.updateGun(item,id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Gun com id inserido não existe.", false, 400, "O Gun não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response delete(String id) {
        boolean item = controller.remove(id);
        if (item) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O Gun com id inserido não existe.", false, 400, "O Gun não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }


    //COMPATIBILITY
    public Response addCompatibilityBarrel(String id, String att) {
        Gun item = controller.addCompatibilityBarrel(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response addCompatibilityBt(String id, String att) {
        Gun item = controller.addCompatibilityBt(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response addCompatibilityMagazine(String id, String att) {
        Gun item = controller.addCompatibilityMagazine(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response addCompatibilitySight(String id, String att) {
        Gun item = controller.addCompatibilitySight(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    //PUT AN ATTACHMENT

    public Response putBarrel(String id, String att) {
        Gun item = controller.putBarrel(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response putButtStock(String id, String att) {
        Gun item = controller.putButtStock(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response putMagazine(String id, String att) {
        Gun item = controller.putMagazine(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response putSight(String id, String att) {
        Gun item = controller.putSight(id,att);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    //REMOVE AN ATTACHMENT
    public Response delBarrel(String id) {
        Gun item = controller.delBarrel(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response delButtStock(String id) {
        Gun item = controller.delButtStock(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response delMagazine(String id) {
        Gun item = controller.delMagazine(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    public Response delSight(String id) {
        Gun item = controller.delSight(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "Gun alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("A url inserida contém elementos de ID inválidos.", false, 400, "O Gun não pôde ser alterado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

}