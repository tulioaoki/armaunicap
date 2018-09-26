/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomResponses;

import javax.ws.rs.core.Response;

/**
 *
 * @author tulioaoki
 */
public interface ResponseBuilder {
    public Response post (Object obj);
    public Response list ();
    public Response get (String id);
    public Response put (String id, Object obj);
    public Response delete (String id);
}
