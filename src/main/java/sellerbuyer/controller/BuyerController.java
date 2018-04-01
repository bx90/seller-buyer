package sellerbuyer.controller;

import sellerbuyer.model.bean.Buyer;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.datacollection.project.BuyerProjectCollection;
import sellerbuyer.model.datacollection.project.ProjectCollector;
import sellerbuyer.model.datacollection.project.SellerProjectCollection;
import sellerbuyer.model.manager.BidManager;
import sellerbuyer.model.manager.BuyerManager;
import sellerbuyer.model.manager.ProjectManager;
import sellerbuyer.util.exception.ValidationException;

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
    private static BuyerManager buyerManager = new BuyerManager();

    @GET
    @Path("/{buyerId}")
    public Buyer getSeller(@PathParam("buyerId") Long id, @Context UriInfo uriInfo) throws ValidationException {
        buyerManager.validate(id);
        return buyerManager.getBuyer(id);
    }

    @Path("/{buyerId}/projects")
    public ProjectController getProjectResource(@PathParam("buyerId") Long id) throws ValidationException {
        buyerManager.validate(id);
        return new ProjectController.Builder()
                                    .BuyerManager(buyerManager)
                                    .ProjectCollector(new ProjectCollector())
                                    .ProjectCollectionStrategy(new BuyerProjectCollection())
                                    .build();
    }


}
