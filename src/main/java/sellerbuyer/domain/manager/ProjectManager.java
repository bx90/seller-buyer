package sellerbuyer.domain.manager;

import sellerbuyer.bean.Project;
import sellerbuyer.util.database.ProjectTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class ProjectManager {
    private Map<Long, Project> projects = ProjectTable.getProjectList();

    public Project addProject(Project project) {
        project.setProjectId((long) projects.size() + 1);
        projects.put(project.getProjectId(), project);
        return project;
    }
    // This dangerous !!!!!
    // TODO change exposure base on visitor.
    public List<Project> getProject() {
        return new ArrayList<>(projects.values());
    }

    public Project getProject(Long projectId) {
        return projects.get(projectId);
    }
}
