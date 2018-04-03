package sellerbuyer.util.dao.project;

import sellerbuyer.model.bean.Project;

import java.util.List;

/**
 * @author bsun
 */
public interface ProjectDao {
    List<Project> getAll();
    Project getById(Long id);
    Project add(Project project);
}
