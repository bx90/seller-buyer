package sellerbuyer.service;

import sellerbuyer.bean.Project;
import sellerbuyer.bean.Seller;
import sellerbuyer.domain.manager.ProjectManager;
import sellerbuyer.domain.manager.SellerManager;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * @author Boxiong
 * @date 3/28/18
 **/

@Path("/sellers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SellerService {
    private ProjectManager projectManager = new ProjectManager();
    private SellerManager sellerManager = new SellerManager();

    @GET
    @Path("/{sellerId}")
    public Seller getSeller(@PathParam("sellerId") Long id, @Context UriInfo uriInfo) {
        return sellerManager.getSeller(id);

    }

    @Path("/{sellerId}/projects")
    public ProjectService getProjectResource() {
        return new ProjectService(sellerManager);
    }
}
