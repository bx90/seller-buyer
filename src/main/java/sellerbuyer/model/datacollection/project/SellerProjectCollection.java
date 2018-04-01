package sellerbuyer.model.datacollection.project;

import sellerbuyer.model.bean.Project;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class SellerProjectCollection implements ProjectCollectionStrategy {
    @Override
    public Project collect(Project inputProject) {
        return inputProject;
    }
}
