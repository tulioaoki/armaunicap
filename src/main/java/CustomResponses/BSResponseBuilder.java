/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomResponses;

import Controller.ButtStockController;
import arma.ButtStock;
import java.util.ArrayList;
import javax.ws.rs.core.Response;

/**
 *
 * @author tulioaoki
 */
public class BSResponseBuilder implements ResponseBuilder {

    private ButtStockController controller = new ButtStockController();

    @Override
    public Response post(Object obj) {
        ButtStock item = (ButtStock) obj;
        item = controller.createButtStock(item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 201, "ButtStock criado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O id inserido já existe.", false, 400, "O ButtStock não pôde ser criado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response list() {
        ArrayList item = controller.getButtStocks();
        CustomResponse r = new CustomResponse(item, true, 200, "ButtStocks listados com sucesso.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response get(String id) {
        ButtStock item = controller.getById(id);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "ButtStock retornado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O ButtStock com id inserido não existe.", false, 400, "O ButtStock não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response put(String id, Object obj) {
        ButtStock item = (ButtStock) obj;
        item = controller.updateButtStock(id, item);
        if (item != null) {
            CustomResponse r = new CustomResponse(item, true, 200, "ButtStock alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O ButtStock com id inserido não existe.", false, 400, "O ButtStock não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

    @Override
    public Response delete(String id) {
        boolean item = controller.removeButtStock(id);
        if (item) {
            CustomResponse r = new CustomResponse(item, true, 200, "ButtStock alterado com sucesso.");
            return Response.status(r.getStatus_code()).entity(r).build();
        }
        CustomResponse r = new CustomResponse("O ButtStock com id inserido não existe.", false, 400, "O ButtStock não pôde ser encontrado.");
        return Response.status(r.getStatus_code()).entity(r).build();
    }

}
