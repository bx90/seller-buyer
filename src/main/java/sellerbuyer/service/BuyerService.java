package sellerbuyer.service;

import sellerbuyer.bean.Project;
import sellerbuyer.domain.manager.ProjectManager;

import java.util.List;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class BuyerService {
    private ProjectManager projectManager = new ProjectManager();

    public List<Project> getProjects() {
        return projectManager.getProject();
    }
}
