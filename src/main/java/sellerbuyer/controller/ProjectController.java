package sellerbuyer.controller;

import sellerbuyer.model.bean.Project;
import sellerbuyer.model.datacollection.project.ProjectCollectionStrategy;
import sellerbuyer.model.datacollection.project.ProjectCollector;
import sellerbuyer.model.manager.BuyerManager;
import sellerbuyer.model.manager.ProjectManager;
import sellerbuyer.model.manager.SellerManager;
import sellerbuyer.util.exception.ValidationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author Boxiong
 * @date 3/29/18
 **/

@Path("/")
public class ProjectController {
    private ProjectManager projectManager = new ProjectManager();
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
    public Project addProject(@PathParam("sellerId") Long sellerId, Project project) throws ValidationException {
        Project newProject = projectManager.addProject(project);
        newProject.setSellerId(sellerId);
        sellerManager.getSeller(sellerId)
                .getProjectList()
                .add(newProject);

        return newProject;
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
    public BidController getBidResource(@PathParam("buyerId") Long buyerId) {
        return new BidController(projectManager, buyerManager);
    }
}
