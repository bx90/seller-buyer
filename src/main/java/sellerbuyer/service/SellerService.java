package sellerbuyer.service;

import sellerbuyer.bean.Project;
import sellerbuyer.domain.manager.ProjectManager;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class SellerService {
    private ProjectManager projectManager = new ProjectManager();

    public Project addProject(Project project) {
        Project newProject = projectManager.addProject(project);
        return newProject;
    }

    public Project getProject(Long projectId) {
        return projectManager.getProject(projectId);
    }
}
