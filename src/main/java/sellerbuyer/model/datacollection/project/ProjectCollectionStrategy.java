package sellerbuyer.model.datacollection.project;

import sellerbuyer.model.bean.Project;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public interface ProjectCollectionStrategy {
    Project collect(Project inputProject);
}
