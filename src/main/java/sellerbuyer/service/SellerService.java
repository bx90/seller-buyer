package sellerbuyer.service;

import sellerbuyer.bean.Project;
import sellerbuyer.domain.manager.ProjectManager;
import sellerbuyer.domain.manager.SellerManager;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class SellerService {
    private ProjectManager projectManager = new ProjectManager();
    private SellerManager sellerManager = new SellerManager();

    public Project addProject(Project project, Long sellerId) {
        Project newProject = projectManager.addProject(project);
        newProject.setSellerId(sellerId);
        sellerManager.getSeller(sellerId)
                     .getProjectList()
                     .add(newProject);

        return newProject;
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
