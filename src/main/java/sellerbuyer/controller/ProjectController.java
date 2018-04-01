package sellerbuyer.controller;

import sellerbuyer.model.bean.Project;
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

    public ProjectController(SellerManager sellerManager) {
        this.sellerManager = sellerManager;
    }

    public ProjectController(BuyerManager buyerManager) {
        this.buyerManager = buyerManager;
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
        return projectManager.getProject(projectId);
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
