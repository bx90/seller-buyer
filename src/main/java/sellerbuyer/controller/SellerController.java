package sellerbuyer.controller;

import sellerbuyer.model.bean.Seller;
import sellerbuyer.model.datacollection.project.ProjectCollector;
import sellerbuyer.model.datacollection.project.SellerProjectCollection;
import sellerbuyer.model.manager.ProjectManager;
import sellerbuyer.model.manager.SellerManager;

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
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class SellerController {
    private ProjectManager projectManager = new ProjectManager();
    private SellerManager sellerManager = new SellerManager();

    @GET
    @Path("/{sellerId}")
    public Seller getSeller(@PathParam("sellerId") Long id, @Context UriInfo uriInfo) {
        return sellerManager.getSeller(id);

    }

    @Path("/{sellerId}/projects")
    public ProjectController getProjectResource() {
        return new ProjectController(sellerManager, new ProjectCollector(), new SellerProjectCollection());
    }
}
