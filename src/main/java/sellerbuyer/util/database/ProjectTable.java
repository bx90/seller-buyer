package sellerbuyer.util.database;

import sellerbuyer.model.bean.Project;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class ProjectTable {
    private static Map<Long, Project> projectList = new HashMap<>();

    public static Map<Long, Project> getProjectList() {
        return projectList;
    }
}

