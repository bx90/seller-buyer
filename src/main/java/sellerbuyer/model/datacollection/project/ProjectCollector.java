package sellerbuyer.model.datacollection.project;

import sellerbuyer.model.bean.Project;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class ProjectCollector implements ProjectCollectionStrategy {
    private ProjectCollectionStrategy projectCollectionStrategy;

    public void setProjectCollectionStrategy(ProjectCollectionStrategy projectCollectionStrategy) {
        this.projectCollectionStrategy = projectCollectionStrategy;
    }

    @Override
    public Project collect(Project inputProject) {
        return projectCollectionStrategy.collect(inputProject);
    }
}
