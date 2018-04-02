package sellerbuyer.model.manager;

import sellerbuyer.model.bean.Project;
import sellerbuyer.model.bean.Seller;
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

    public Project addProject(Project project, Seller seller) throws ValidationException {
        initializeProject(project, seller);
        validation(project);
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

    private void initializeProject(Project project, Seller seller) throws ValidationException {
        project.setSeller(seller);
        project.setSellerId(seller.getSellerId());
        project.setProjectId((long) projects.size());
        project.setActive(true);
        project.setCreateDate(ZonedDateTime.now());
        project.setDueDate(TimeTransformer.getZonedDateTime(project.getUserInputDueDate()));
    }


    private void storeProject(Project project) {
        projects.put(project.getProjectId(), project);
    }

    public void validateBeforeBid(Long id) throws ValidationException {
        if (projects.get(id) == null) {
            throw new ValidationException("Project with id: " + Long.toString(id) + " does not exist.");
        }

        if (!projects.get(id).isActive()) {
            throw new ValidationException("Project " + Long.toString(id) + " is not valid any more.");
        }
    }
}
