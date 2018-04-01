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
        validation(project);
        initializeProject(project, sellerId);
        storeProject(project);
        return project;
    }
    public List<Project> getProject() {
        return new ArrayList<>(projects.values());
    }

    public Project getProject(Long projectId) {
        return projects.get(projectId);
    }

    private void validation(Project project) throws ValidationException {
        if (project.getDueDate() == null) {
            throw new ValidationException("Due date is a mandatory field. Please enter a valid due date. E.g.: 2020-07-05T22:00");
        }

        // compare date.
        if (project.getDueDate().isBefore(project.getCreateDate())) {
            throw new ValidationException("Due date is not valid. It needs to be after the project created time.");
        }

        if (project.getDescription() == null || project.getDescription().length() == 0 || project.getDescription().length() > 100) {
            throw new ValidationException("Description is a mandatory field. Please provide description within 100 character.");
        }
        // add date format checking, or limit the format in the UI.
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
