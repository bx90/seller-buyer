package sellerbuyer.controller;

import sellerbuyer.bean.Project;
import sellerbuyer.domain.manager.BuyerManager;
import sellerbuyer.domain.manager.ProjectManager;
import sellerbuyer.domain.manager.SellerManager;
import sellerbuyer.util.exception.ValidationException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
//    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces(MediaType.APPLICATION_JSON)
    public Project addProject(@PathParam("sellerId") Long sellerId, Project project) throws ValidationException {
        if (project.getDueDate() == null) {
           throw new ValidationException("Due Date is not set.");
        }
        Project newProject = projectManager.addProject(project);
        newProject.setSellerId(sellerId);
        sellerManager.getSeller(sellerId)
                .getProjectList()
                .add(newProject);

        return newProject;
    }

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
