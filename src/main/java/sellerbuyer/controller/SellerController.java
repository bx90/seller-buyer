package sellerbuyer.controller;

import sellerbuyer.model.bean.Seller;
import sellerbuyer.model.datacollection.project.ProjectCollector;
import sellerbuyer.model.datacollection.project.SellerProjectCollection;
import sellerbuyer.model.manager.SellerManager;
import sellerbuyer.util.exception.ValidationException;

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
public class SellerController {
    private static SellerManager sellerManager;

    static {
        sellerManager = new SellerManager();
    }
    @GET
    @Path("/{sellerId}")
    public Seller getSeller(@PathParam("sellerId") Long id, @Context UriInfo uriInfo) throws ValidationException {
        sellerManager.validate(id);
        Seller seller = sellerManager.getSeller(id);
        seller.addLink(getUriForSelf(uriInfo, seller), "self");
        return seller;
    }


    @Path("/{sellerId}/projects")
    public ProjectController getProjectResource(@PathParam("sellerId") Long id) throws ValidationException {
        sellerManager.validate(id);
        return new ProjectController.Builder()
                                    .SellerManager(sellerManager)
                                    .ProjectCollector(new ProjectCollector())
                                    .ProjectCollectionStrategy(new SellerProjectCollection())
                                    .build();
    }


    private String getUriForSelf(UriInfo uriInfo, Seller seller) {
        seller.getLinks().clear();
        return uriInfo.getBaseUriBuilder()
                      .path(SellerController.class)
                      .path(Long.toString(seller.getSellerId()))
                      .build()
                      .toString();
    }


}
