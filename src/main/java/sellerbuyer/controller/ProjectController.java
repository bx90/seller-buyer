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
// MUST HAVE: builder Pattern
    protected ProjectController(SellerManager sellerManager, ProjectCollector projectCollector, ProjectCollectionStrategy strategy) {
        this.sellerManager = sellerManager;
        this.projectCollector = projectCollector;
        projectCollector.setProjectCollectionStrategy(strategy);
    }

    protected ProjectController(BuyerManager buyerManager, ProjectCollector projectCollector, ProjectCollectionStrategy strategy) {
        this.buyerManager = buyerManager;
        this.projectCollector = projectCollector;
        projectCollector.setProjectCollectionStrategy(strategy);
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
    public Project getProject(@PathParam("projectId") Long projectId) {
        return projectCollector.collect(projectManager.getProject(projectId));
    }

    // Buyer:
    @Path("/{projectId}/bids")
    public BidController getBidResource(@PathParam("buyerId") Long buyerId) {
        return new BidController(projectManager, buyerManager);
    }


    // Only checking own project.
    // Since at the moment sellers have privilege to check project
    // bid list.
    public Project getProject(Long projectId, Long sellerId) {
        Project project = projectManager.getProject(projectId);
        return project.getSellerId().equals(sellerId) ? project : null;
    }

//    public Project getOwnProject(Long sellerId) {
//
//    }
}
