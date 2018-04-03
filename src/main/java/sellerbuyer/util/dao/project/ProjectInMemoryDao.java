package sellerbuyer.util.dao.project;

import sellerbuyer.model.bean.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bsun
 */
public class ProjectInMemoryDao implements ProjectDao {
    private static Map<Long, Project> projectTable = new HashMap<>();
    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projectTable.values());
    }

    @Override
    public Project getById(Long id) {
        return projectTable.get(id);
    }

    @Override
    public Project add(Project project) {
        Long id = (long) projectTable.size();
        project.setProjectId(id);
        projectTable.put(project.getProjectId(), project);
        return project;
    }
}
