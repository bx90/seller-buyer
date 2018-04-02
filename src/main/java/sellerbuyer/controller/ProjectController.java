package sellerbuyer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.bean.Seller;
import sellerbuyer.model.datacollection.project.ProjectCollectionStrategy;
import sellerbuyer.model.datacollection.project.ProjectCollector;
import sellerbuyer.model.manager.BuyerManager;
import sellerbuyer.model.manager.ProjectManager;
import sellerbuyer.model.manager.SellerManager;
import sellerbuyer.util.exception.ValidationException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Boxiong
 * @date 3/29/18
 **/

@Path("/")
public class ProjectController {
//    private static Logger logger = LoggerFactory.getLogger(ProjectCollector.class);

    private static ProjectManager projectManager;

    static {
        projectManager = new ProjectManager();
    }

    private SellerManager sellerManager;
    private BuyerManager buyerManager;
    private ProjectCollector projectCollector;
    private ProjectCollectionStrategy strategy;

    private ProjectController(Builder builder) {
        this.sellerManager = builder.sellerManager;
        this.buyerManager = builder.buyerManager;
        this.projectCollector = builder.projectCollector;
        this.strategy = builder.strategy;
    }

    public static class Builder {
        private SellerManager sellerManager;
        private BuyerManager buyerManager;
        private ProjectCollector projectCollector;
        private ProjectCollectionStrategy strategy;

        public Builder SellerManager(SellerManager sellerManager) {
            this.sellerManager = sellerManager;
            return this;
        }

        public Builder BuyerManager(BuyerManager buyerManager) {
            this.buyerManager = buyerManager;
            return this;
        }

        public Builder ProjectCollector(ProjectCollector projectCollector) {
            this.projectCollector = projectCollector;
            return this;
        }

        public Builder ProjectCollectionStrategy(ProjectCollectionStrategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public ProjectController build() {
            return new ProjectController(this);
        }
    }

    // Seller:
    @POST
    public Response addProject(@PathParam("sellerId") Long sellerId,
                               Project project,
                               @Context UriInfo uriInfo) throws ValidationException {

        sellerManager.validate(sellerId);
        Seller seller = sellerManager.getSeller(sellerId);
        Project newProject = projectManager.addProject(project, seller);
        sellerManager.linkProjectWithSeller(sellerId, newProject);
        URI uri = uriInfo.getAbsolutePathBuilder()
                         .path(newProject.getProjectId().toString())
                         .build();

        return Response.created(uri)
                       .entity(newProject)
                       .build();
    }
    @GET
    @Path("/{projectId}")
    public Project getProject(@PathParam("projectId") Long projectId) throws ValidationException {
        Project returnProject = projectManager.getProject(projectId);
        if (returnProject == null) {
            throw new ValidationException("Cannot find project with id " + projectId);
        }
        projectCollector.setProjectCollectionStrategy(strategy);
        return projectCollector.collect(returnProject);

    }

    // Buyer:
    @Path("/{projectId}/bids")
    public BidController getBidResource(@PathParam("buyerId") Long buyerId,
                                        @PathParam("projectId") Long projectId) throws ValidationException {
        projectManager.validateBeforeBid(projectId);
        return new BidController(projectManager, buyerManager);
    }
}
