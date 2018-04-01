package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Project;
import sellerbuyer.util.database.ProjectTable;
import sellerbuyer.util.exception.ValidationException;
import sellerbuyer.util.time.TimeTransformer;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class ProjectManager {
    private Map<Long, Project> projects = ProjectTable.getProjectList();

    public Project addProject(Project project, Long sellerId) throws ValidationException {
//        project.setProjectId((long) projects.size() + 1);
//        project.setActive(true);
//        project.setCreateDate(ZonedDateTime.now());
//        project.setDueDate(TimeTransformer.getZonedDateTime(project.getUserInputDueDate()));
        validation(project);
        initializeProject(project, sellerId);
        storeProject(project);
//        projects.put(project.getProjectId(), project);
        return project;
    }
    public List<Project> getProject() {
        return new ArrayList<>(projects.values());
    }

    public Project getProject(Long projectId) {
        return projects.get(projectId);
    }

    private void validation(Project project) throws ValidationException {
        System.out.println(ZonedDateTime.now());
        if (project.getDueDate() == null) {
            throw new ValidationException("Due date is not set.");
        }

        // compare date.
        if (project.getDueDate().isBefore(project.getCreateDate())) {
            throw new ValidationException("Due date is not valid. It needs to be after the project created time.");
        }

        if (project.getDescription() == null || project.getDescription().length() == 0 || project.getDescription().length() > 100) {
            throw new ValidationException("Description is a mandatory field. Please provide description within 100 character.");
        }

    }

    private void initializeProject(Project project, Long sellerId) throws ValidationException {
        project.setSellerId(sellerId);
        project.setProjectId((long) projects.size() + 1);
        project.setActive(true);
        project.setCreateDate(ZonedDateTime.now());
        project.setDueDate(TimeTransformer.getZonedDateTime(project.getUserInputDueDate()));
    }


    private void storeProject(Project project) {
        projects.put(project.getProjectId(), project);
    }
}