package sellerbuyer.controller;

import sellerbuyer.model.bean.Buyer;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.manager.BidManager;
import sellerbuyer.model.manager.BuyerManager;
import sellerbuyer.model.manager.ProjectManager;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
@Path("/buyers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BuyerController {
    private ProjectManager projectManager = new ProjectManager();
    private BuyerManager buyerManager = new BuyerManager();
    private BidManager bidManager = new BidManager();

    @GET
    @Path("/{buyerId}")
    public Buyer getSeller(@PathParam("buyerId") Long id, @Context UriInfo uriInfo) {
        return buyerManager.getBuyer(id);
    }

    @Path("/{buyerId}/projects")
    public ProjectController getProjectResource() {
        return new ProjectController(buyerManager);
    }


    public List<Project> getProjects() {
        return projectManager.getProject();
    }


}
